package br.com.nadson.desafiosc4.principal;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificandoSeUmaStringContemUmaSubstring {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {

            System.out.println("Digite uma frase:");
            String frase = entrada.nextLine().trim();

            System.out.println("Digite uma palavra:");
            String palavra = entrada.nextLine().trim();

            String regex = "(?i)\\b" + Pattern.quote(palavra) + "\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(frase);

            if (matcher.find()) {
                System.out.println("A frase contém a palavra exata: " + palavra);
            } else {
                System.out.println("A frase NÃO contém a palavra exata.");
            }
        }
    }
}
