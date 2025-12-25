package br.com.nadson.screeanmatch.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ConsumoApi {

    @Value("${omdb.api.key}")
    private String apiKey;

    public String obterDados(String endereco) {

        if (apiKey == null || apiKey.isBlank()) {
            throw new RuntimeException("OMDB API Key não configurada");
        }

        String url = endereco + "&apikey=" + apiKey;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response =
                    HttpClient.newHttpClient()
                            .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao consumir a API do OMDB.", e);
        }
    }
}
