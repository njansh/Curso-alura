package com.nadson.ScreenSoundMusicas.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                // Identificação oficial recomendada pela API da Wikipédia
                .header("User-Agent", "ScreenSoundMusicas/1.0 (nadsonjhonyobmep@gmail.com)")
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro na requisição: " + e.getMessage(), e);
        }
        return response.body();
    }
}