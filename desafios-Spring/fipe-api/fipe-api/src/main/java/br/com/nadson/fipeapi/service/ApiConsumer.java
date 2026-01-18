package br.com.nadson.fipeapi.service;

import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ApiConsumer {


    public String obterDados(String endereco) {


        String url = endereco;

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
            throw new RuntimeException("Erro ao consumir a API da FIPE.", e);
        }

    }

}