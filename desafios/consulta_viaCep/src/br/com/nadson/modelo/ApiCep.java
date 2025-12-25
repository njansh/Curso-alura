package br.com.nadson.modelo;

import br.com.nadson.excessao.CepInvalidoException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiCep {

    private String cep;
    private final HttpClient client = HttpClient.newHttpClient();

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String consultar() {
        validarCep();

        String endereco = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 400) {
                throw new CepInvalidoException("CEP inválido: " + cep);
            }

            return response.body();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Falha ao consultar API: " + e.getMessage());
        }
    }

    private void validarCep() {
        if (cep == null || cep.isBlank()) {
            throw new CepInvalidoException("CEP não informado.");
        }

        if (!cep.matches("\\d{8}")) {
            throw new CepInvalidoException("CEP deve conter exatamente 8 números.");
        }
    }
}
