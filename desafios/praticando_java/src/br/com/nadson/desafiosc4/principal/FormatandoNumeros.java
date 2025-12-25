package br.com.nadson.desafiosc4.principal;

import java.util.Scanner;

public class FormatandoNumeros {
    public static void main(String[] args) {
        try(Scanner entrada = new Scanner(System.in)){
            System.out.println("Digite um valor");
            double valor=entrada.nextDouble();
            String valorFormatado=String.format("R$%.2f",valor);

            System.out.println("O valor formatado é "+valorFormatado);
        }


    }
}
