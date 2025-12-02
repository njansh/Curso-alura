package br.com.nadson.desafiosc3.principal;

import java.util.Scanner;

public class CalculadoraDeFatorial {

    public static long calcularFatorial(int n) {
        validarNumero(n);
        long fatorial = 1;

        for (int i = 1; i <= n; i++) {
            fatorial *= i;
        }
        return fatorial;
    }

    public static void validarNumero(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("O número deve ser não-negativo.");
        }
    }

    public static int lerNumero(Scanner entrada) {
        System.out.print("Digite um número não-negativo para calcular o fatorial: ");

        while (!entrada.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            entrada.next();
        }

        return entrada.nextInt();
    }

    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {

            int numero = lerNumero(entrada);

            try {
                long resultado = calcularFatorial(numero);
                System.out.println("O fatorial de " + numero + " é " + resultado);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
