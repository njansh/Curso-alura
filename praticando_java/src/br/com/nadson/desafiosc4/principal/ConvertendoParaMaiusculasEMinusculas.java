package br.com.nadson.desafiosc4.principal;

import java.util.Scanner;

public class ConvertendoParaMaiusculasEMinusculas {
    public static void main(String[] args) {



            try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Digite o nome: ");
                String nome = entrada.nextLine();
                String nomeMaiusculo = nome.toUpperCase();
                String nomeMinusculo = nome.toLowerCase();

            System.out.printf("Nome em maiusculo: '%s'%nNome em maiúsculas: '%s'%nNome em minúsculas: '%s'%n",nomeMaiusculo,nomeMinusculo );



            }
    }
}
