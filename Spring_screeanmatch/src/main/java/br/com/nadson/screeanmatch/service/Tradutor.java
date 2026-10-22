
package br.com.nadson.screeanmatch.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class Tradutor {

    private static final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .build();

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String traduzir(String texto) {
        if (texto == null || texto.isBlank()) {
            return "";
        }

        try {
            // Garante que o LibreTranslate esteja disponível.
            if (!DockerService.assegurarTradutorDisponivel()) {
                return texto;
            }

            // Monta o JSON enviado para o LibreTranslate.
            String jsonPayload = mapper.writeValueAsString(new Object() {
                public final String q = texto;
                public final String source = "en";
                public final String target = "pt";
                public final String format = "text";
            });

            String url = "http://localhost:5000/translate";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .timeout(Duration.ofSeconds(30))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(
                            jsonPayload,
                            StandardCharsets.UTF_8
                    ))
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            if (response.statusCode() < 200
                    || response.statusCode() >= 300) {
                System.err.println(
                        "[Tradutor] API retornou HTTP "
                                + response.statusCode()
                );
                return texto;
            }

            JsonNode root = mapper.readTree(response.body());
            JsonNode translatedTextNode = root.path("translatedText");

            if (translatedTextNode.isMissingNode()
                    || translatedTextNode.isNull()
                    || translatedTextNode.asText().isBlank()) {
                return texto;
            }

            return translatedTextNode.asText().trim();

        } catch (Exception e) {
            System.err.println(
                    "[Erro Tradutor] Falha ao traduzir: "
                            + e.getMessage()
            );

            return texto;
        }
    }
}
