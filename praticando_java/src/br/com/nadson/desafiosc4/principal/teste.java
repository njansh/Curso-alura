package br.com.nadson.desafiosc4.principal;

import java.util.Scanner;

public class teste {
    
    public static void main(String[] args) {
        // A sintaxe correta do try-with-resources não tem a chave "{" dentro dos parênteses.
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Digite o nome: ");
            String nome = entrada.nextLine();

            String nomeMaiusculo = nome.toUpperCase();
            String nomeMinusculo = nome.toLowerCase();

            // Você precisa passar as variáveis que o printf vai usar para preencher os '%s'.
            // Adicionei também o nome original para comparação.
            System.out.printf("Nome original: '%s'%nNome em maiúsculas: '%s'%nNome em minúsculas: '%s'%n",
                    nome, nomeMaiusculo, nomeMinusculo);
        }
    }
}
