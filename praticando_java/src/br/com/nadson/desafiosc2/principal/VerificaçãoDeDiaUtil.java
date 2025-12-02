package br.com.nadson.desafiosc2.principal;

import java.util.Locale;
import java.util.Scanner;

public class VerificaçãoDeDiaUtil {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);


            System.out.println("Diga o dia da semana:");
            String dia = entrada.nextLine().toLowerCase(Locale.ROOT);
            switch (dia) {
                case "segunda" -> diaUtil(dia);
                case "terca" -> diaUtil(dia);
                case "quarta" -> diaUtil(dia);
                case "quinta" -> diaUtil(dia);
                case "sexta" -> diaUtil(dia);
                case "sabado" -> fimDeSemana(dia);
                case "domingo" -> fimDeSemana(dia);
                default -> System.out.println("Dia invalido");
            }



    }

    public static void diaUtil(String dia) {
        System.out.println(dia + " é um dia util");
    }

    public static void fimDeSemana(String dia) {
        System.out.println(dia + " não é um dia util");
    }
}

