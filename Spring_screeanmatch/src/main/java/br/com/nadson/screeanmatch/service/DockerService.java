
package br.com.nadson.screeanmatch.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DockerService {

    private static final String NOME_CONTAINER = "meu-tradutor";
    private static final String URL_API = "http://localhost:5000";
    private static final String CAMINHO_DOCKER_DESKTOP =
            "C:\\Program Files\\Docker\\Docker\\Docker Desktop.exe";

    private static final HttpClient CLIENT = HttpClient.newBuilder()
            .connectTimeout(java.time.Duration.ofSeconds(2))
            .build();

    private DockerService() {
    }

    public static boolean assegurarTradutorDisponivel() {
        // Se a API já estiver funcionando, não precisamos iniciar nada.
        if (apiDisponivel()) {
            return true;
        }

        // Se o Docker não estiver disponível, tentamos abrir o Docker Desktop.
        if (!dockerDisponivel()) {
            iniciarDockerDesktop();

            if (!aguardarDocker(90)) {
                System.err.println(
                        "[DockerService] Docker não ficou disponível a tempo."
                );
                return false;
            }
        }

        // Inicia o contêiner existente. Não cria um novo.
        if (!executarComando("docker", "start", NOME_CONTAINER)) {
            System.err.println(
                    "[DockerService] Não foi possível iniciar o contêiner "
                            + NOME_CONTAINER
            );
            return false;
        }

        // Aguarda o LibreTranslate começar a responder.
        if (!aguardarApi(120)) {
            System.err.println(
                    "[DockerService] LibreTranslate não respondeu a tempo."
            );
            return false;
        }

        System.out.println("[DockerService] LibreTranslate está disponível.");
        return true;
    }

    private static boolean apiDisponivel() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_API + "/languages"))
                    .timeout(java.time.Duration.ofSeconds(4))
                    .GET()
                    .build();

            HttpResponse<String> response = CLIENT.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            return response.statusCode() == 200;

        } catch (Exception e) {
            return false;
        }
    }

    private static boolean dockerDisponivel() {
        return executarComando("docker", "info");
    }

    private static void iniciarDockerDesktop() {
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd", "/c", "start", "",
                    CAMINHO_DOCKER_DESKTOP
            );

            builder.start();

            System.out.println(
                    "[DockerService] Iniciando Docker Desktop..."
            );

        } catch (IOException e) {
            System.err.println(
                    "[DockerService] Não foi possível abrir o Docker Desktop: "
                            + e.getMessage()
            );
        }
    }

    private static boolean aguardarDocker(int segundos) {
        long limite = System.nanoTime()
                + TimeUnit.SECONDS.toNanos(segundos);

        while (System.nanoTime() < limite) {
            if (dockerDisponivel()) {
                return true;
            }

            pausar(2);
        }

        return false;
    }

    private static boolean aguardarApi(int segundos) {
        long limite = System.nanoTime()
                + TimeUnit.SECONDS.toNanos(segundos);

        while (System.nanoTime() < limite) {
            if (apiDisponivel()) {
                return true;
            }

            pausar(2);
        }

        return false;
    }

    private static boolean executarComando(String... comando) {
        Process processo = null;

        try {
            processo = new ProcessBuilder(comando)
                    .redirectErrorStream(true)
                    .start();

            if (!processo.waitFor(10, TimeUnit.SECONDS)) {
                processo.destroyForcibly();
                return false;
            }

            return processo.exitValue() == 0;

        } catch (IOException e) {
            System.err.println(
                    "[DockerService] Erro ao executar comando: "
                            + e.getMessage()
            );
            return false;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            if (processo != null) {
                processo.destroyForcibly();
            }

            return false;
        }
    }

    private static void pausar(int segundos) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(segundos));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
