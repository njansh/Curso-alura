package br.com.nadson.desafiosc4.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtraindoHashtagsDeUmTexto {
    public static void main(String[] args) {
        try(Scanner entrada = new Scanner(System.in)) {
            List<String>hashtags=new ArrayList<>();
            System.out.println("Digite um texto:");
            String texto = entrada.nextLine();
            Pattern pattern = Pattern.compile("#\\w+");
            Matcher matcher = pattern.matcher(texto);


            while (matcher.find()) {
                hashtags.add(matcher.group());
            }

            if (hashtags.isEmpty()) {
                System.out.println("Nenhuma hashtag encontrada.");
            } else {
                System.out.println("Hashtags encontradas:");
                hashtags.forEach(System.out::println);
            }
        }
    }
}


