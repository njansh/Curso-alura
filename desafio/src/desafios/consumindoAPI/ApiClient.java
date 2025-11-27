package desafios.consumindoAPI;

import desafios.consumindoAPI.m3.excessoes.ErroConsultaGitHubException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

public class ApiClient {
    private String endereco;
    private final String chaveGoogle = System.getenv("API_KEY_GOOGLE");

    private final HttpClient httpClient = HttpClient.newHttpClient();

    // ==================  SETTERS DE ENDEREÇO  ==================

    public void setEnderecoBooks(String busca) {
        validarApiKeyGoogle();
        this.endereco = String.format(
                "https://www.googleapis.com/books/v1/volumes?q=%s&apikey=%s",
                busca,
                chaveGoogle
        );
    }

    public void setEnderecoCripto(String busca) {
        this.endereco = String.format(
                "https://api.coingecko.com/api/v3/simple/price?ids=%s&vs_currencies=usd",
                busca
        );
    }

    public void setEnderecoReceita(String busca) {
        this.endereco = String.format(
                "https://www.themealdb.com/api/json/v1/1/search.php?s=%s",
                busca
        );
    }

    public void setEnderecoGit(String usuario) {
        this.endereco = String.format(
                "https://api.github.com/users/%s",
                usuario
        );
    }


    // ==================  MÉTODOS DE REQUISIÇÃO  ==================

    /**
     * Consulta APIs comuns sem headers especiais.
     */
    public String consultar() throws IOException, InterruptedException {
        validarEndereco();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .GET()
                .build();

        return enviar(request).body();
    }

    /**
     * Consulta a API do GitHub com header apropriado.
     */
    public String consultarGit() throws IOException, InterruptedException, ErroConsultaGitHubException {
        validarEndereco();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .header("Accept", "application/vnd.github.v3+json")
                .GET()
                .build();

        HttpResponse<String> response = enviar(request);

        if (response.statusCode() == 404) {
            throw new ErroConsultaGitHubException("Usuário não encontrado no GitHub.");
        }

        return response.body();
    }


    // ==================  MÉTODOS INTERNOS  ==================

    private HttpResponse<String> enviar(HttpRequest request)
            throws IOException, InterruptedException {

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private void validarEndereco() {
        if (endereco == null || endereco.isBlank()) {
            throw new IllegalStateException("O endereço da API não foi definido.");
        }
    }

    private void validarApiKeyGoogle() {
        if (Objects.isNull(chaveGoogle) || chaveGoogle.isBlank()) {
            throw new IllegalStateException(
                    "A variável de ambiente API_KEY_GOOGLE não está definida."
            );
        }
    }
}
