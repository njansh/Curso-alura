package br.com.nadson.desafiosc3.principal;

import java.util.Scanner;

public class PulandoNumerosQueTerminamEm5 {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("Digite o intervalor que deseja que seja mostrado");
            int intervalo = entrada.nextInt();
            for (int i = 0; i <= intervalo; i++) {
                if (i % 10 == 5) {
                    continue;
                }
                System.out.println(i);
            }
        }
    }
}
