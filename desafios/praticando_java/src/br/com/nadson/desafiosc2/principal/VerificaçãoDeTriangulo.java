package br.com.nadson.desafiosc2.principal;

import java.util.Scanner;

public class VerificaçãoDeTriangulo {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o lado A: ");
        double a = entrada.nextDouble();

        System.out.print("Digite o lado B: ");
        double b = entrada.nextDouble();

        System.out.print("Digite o lado C: ");
        double c = entrada.nextDouble();

        if (formaTriangulo(a, b, c)) {
            System.out.println("Os valores formam um triângulo.");
        } else {
            System.out.println("Os valores NÃO formam um triângulo.");
        }

        entrada.close();
    }

     static boolean formaTriangulo(double a, double b, double c) {
        return (a < b + c) && (b < a + c) && (c < a + b);
    }
}
