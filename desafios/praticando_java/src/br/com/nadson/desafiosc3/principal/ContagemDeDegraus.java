package br.com.nadson.desafiosc3.principal;

import java.util.Scanner;

public class ContagemDeDegraus {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite quantos degraus tem:");
        int degraus = entrada.nextInt();

        if (degraus > 0) {
            for (int i = 1; i <= degraus; i++) {
                System.out.println("Você está no degrau " + i);
                System.out.println("Você chegou ao topo");
            }
        } else {
            System.out.println("O número de degraus deve ser um valor positivo.");
        }

        entrada.close();
    }
}
