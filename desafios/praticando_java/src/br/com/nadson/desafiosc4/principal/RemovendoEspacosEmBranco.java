package br.com.nadson.desafiosc4.principal;

import java.util.Scanner;

public class RemovendoEspacosEmBranco {

    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {

            System.out.print("Digite o nome: ");
            String nome = entrada.nextLine();

            String nomeFormatado = nome.trim();

            System.out.printf(
                    // coloquei aspas na mensagem pra ficar visual a diferenca dos espaços
                    "Nome original: '%s'%nNome sem espaços nas extremidades: '%s'%n",
                    nome,
                    nomeFormatado
            );
        }
    }
}
