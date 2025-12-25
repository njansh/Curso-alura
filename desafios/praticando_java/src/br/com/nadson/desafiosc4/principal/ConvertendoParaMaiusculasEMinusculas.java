package br.com.nadson.desafiosc4.principal;

import java.util.Scanner;

public class ConvertendoParaMaiusculasEMinusculas {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {

            System.out.print("Digite o nome: ");
            String nome = entrada.nextLine().trim();

            if (nome.isEmpty()) {
                System.out.println("Nenhum nome digitado.");
                return;
            }

            String nomeMaiusculo = nome.toUpperCase();
            String nomeMinusculo = nome.toLowerCase();

            System.out.printf(
                    "Nome em maiúsculo: '%s'%nNome em minúsculo: '%s'%n",
                    nomeMaiusculo,
                    nomeMinusculo
            );
        }
    }
}
