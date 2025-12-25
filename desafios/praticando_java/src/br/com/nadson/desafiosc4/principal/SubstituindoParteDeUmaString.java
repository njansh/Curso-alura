package br.com.nadson.desafiosc4.principal;

import java.util.Scanner;

public class SubstituindoParteDeUmaString {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {

            System.out.println("Digite uma frase:");
            String frase = entrada.nextLine().trim();

            System.out.println("Digite a palavra que você deseja substituir:");
            String palavra = entrada.nextLine().trim();

            String regex = "(?i)\\b" + palavra + "\\b";

            if (frase.replaceAll("(?i)", "").matches(".*" + regex + ".*")) {
                System.out.println("Digite a nova palavra:");
                String novaPalavra = entrada.nextLine().trim();

                frase = frase.replaceAll(regex, novaPalavra);
            } else {
                System.out.println("Essa palavra não está na frase.");
            }

            System.out.println("Resultado final:");
            System.out.println(frase);
        }
    }
}
