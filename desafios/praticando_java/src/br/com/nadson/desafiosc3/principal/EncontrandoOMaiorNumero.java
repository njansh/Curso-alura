package br.com.nadson.desafiosc3.principal;

import java.util.Scanner;

public class EncontrandoOMaiorNumero {
    public static void main(String[] args) {
        try(Scanner entrada = new Scanner(System.in)){
        System.out.println("Quantos numeros quer digitar");
        int qtNumeros=entrada.nextInt();
        int maior = Integer.MIN_VALUE;
        for (int i = 0; i < qtNumeros; i++) {
            System.out.print("Digite um número: ");
            int num = entrada.nextInt();

            if (num > maior) {
                maior = num;
            }
        }

        System.out.println("O maior número é: " + maior);
    }}
}
