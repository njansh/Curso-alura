package br.com.nadson.screeanmatch.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Tradutor {

    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper mapper = new ObjectMapper();

    public String traduzir(String texto) {

        try {

            String encoded = URLEncoder.encode(texto, StandardCharsets.UTF_8);

            String url =
                    "https://api.mymemory.translated.net/get?q="
                            + encoded
                            + "&langpair=en%7Cpt";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonNode node = mapper.readTree(response.body());

            return node
                    .get("responseData")
                    .get("translatedText")
                    .asText();

        } catch (Exception e) {
            e.printStackTrace();
            return texto;
        }
    }
}