package br.com.nadson.principal;

import br.com.nadson.excessao.CepInvalidoException;
import br.com.nadson.modelo.ApiCep;
import br.com.nadson.modelo.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ApiCep api = new ApiCep();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Endereco> enderecos = new ArrayList<>();

        try (FileWriter escrita = new FileWriter("enderecos.json")) {

            while (true) {
                System.out.println("Digite um CEP (ou 'sair' para terminar): ");
                String cepDigitado = entrada.nextLine().trim();

                if (cepDigitado.equalsIgnoreCase("sair")) {
                    break;
                }

                try {
                    api.setCep(cepDigitado);
                    String json = api.consultar();

                    if (json.contains("\"erro\": true")) {
                        throw new CepInvalidoException("CEP não encontrado: " + cepDigitado);
                    }

                    Endereco endereco = gson.fromJson(json, Endereco.class);
                    enderecos.add(endereco);

                    System.out.println("Endereço adicionado!");

                } catch (CepInvalidoException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (RuntimeException e) {
                    System.out.println("Falha ao consultar API: " + e.getMessage());
                }
            }

            escrita.write(gson.toJson(enderecos));

            System.out.println("Arquivo salvo com sucesso.");

        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }

        System.out.println("Programa finalizado.");
    }
}
