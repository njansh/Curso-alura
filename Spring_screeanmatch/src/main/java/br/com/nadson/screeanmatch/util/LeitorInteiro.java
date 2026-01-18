package br.com.nadson.screeanmatch.util;

import java.util.Scanner;

public class LeitorInteiro {


    public static int ler(String mensagem, Scanner scanner) {
        while (true) {
            System.out.println(mensagem);
            String entrada = scanner.nextLine();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            }
        }

    }
    public static int ler(String mensagem, Scanner scanner, int min, int max) {
        while (true) {
            System.out.println(mensagem);
            try {
                int valor = Integer.parseInt(scanner.nextLine());
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.printf("Digite um número entre %d e %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            }
        }
    }

}
