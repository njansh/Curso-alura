package br.com.nadson.desafiosc4.principal;

import java.util.Scanner;

public class ExtraindoParteDeUmaString {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {

            System.out.print("Digite o nome do arquivo: ");
            String arquivo = entrada.nextLine().trim();

            if (arquivo.isEmpty()) {
                System.out.println("Nenhum nome digitado.");
                return;
            }

            int posicaoPonto = arquivo.lastIndexOf('.');

            if (posicaoPonto > 0 && posicaoPonto < arquivo.length() - 1) {
                String nomeSemExtensao = arquivo.substring(0, posicaoPonto);
                String extensao = arquivo.substring(posicaoPonto + 1);

                System.out.println("Arquivo sem extensão: " + nomeSemExtensao);
                System.out.println("Extensão: " + extensao);
            } else {
                System.out.println("Não possui extensão: " + arquivo);
            }
        }
    }
}
