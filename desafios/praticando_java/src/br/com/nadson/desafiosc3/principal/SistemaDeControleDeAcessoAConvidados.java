package br.com.nadson.desafiosc3.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaDeControleDeAcessoAConvidados {

    public static void main(String[] args) {
        List<String> convidados = new ArrayList<>();

        try (Scanner entrada = new Scanner(System.in)) {

            while (true) {
                System.out.println("\nDigite o nome do convidado:");
                System.out.println("• Digite 'ver' para listar convidados");
                System.out.println("• Digite 'sair' para finalizar");
                System.out.print("Entrada: ");

                String entradaUsuario = entrada.nextLine().trim();

                if (entradaUsuario.isEmpty()) {
                    System.out.println("Entrada vazia. Digite algo válido.");
                    continue;
                }

                if (entradaUsuario.equalsIgnoreCase("ver")) {
                    if (convidados.isEmpty()) {
                        System.out.println("Nenhum convidado registrado.");
                    } else {
                        System.out.println("Convidados cadastrados: " + convidados);
                    }
                    continue;
                }

                if (entradaUsuario.equalsIgnoreCase("sair")) {
                    System.out.println("Finalizando programa...");
                    break;
                }

                if (convidados.stream().anyMatch(c -> c.equalsIgnoreCase(entradaUsuario))) {
                    System.out.println(entradaUsuario + " já está registrado(a).");
                } else {
                    convidados.add(entradaUsuario);
                    System.out.println(entradaUsuario + " foi adicionado(a) à lista.");
                }
            }
        }
    }
}
