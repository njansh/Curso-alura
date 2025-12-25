package br.com.nadson.desafiosc3.principal;

import java.util.Scanner;

public class PedindoUmNomeValido {

    public static void main(String[] args) {

try(Scanner entrada = new Scanner(System.in)){
        String nome = solicitarNomeValido(entrada);

        System.out.println("Olá, " + nome + "!");
        System.out.println("Usuário cadastrado com sucesso");

        }
    }

    private static String solicitarNomeValido(Scanner entrada) {
        String nome;

        while (true) {
            System.out.print("Digite seu nome: ");
            nome = entrada.nextLine();

            if (nome != null && !nome.isEmpty() && nome.length() >= 3) {
                return nome;
            }

            System.out.println("Nome inválido. Digite novamente.\n");
        }
    }
}
