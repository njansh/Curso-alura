package br.com.nadson.desafiosc2.principal;

import java.util.Scanner;

public class ComparandoDoisNúmeros {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o primeiro numero para a verificação:");
        int numero1 = entrada.nextInt();
        System.out.println("Agora digite o segundo numero :");
        int numero2= entrada.nextInt();
        if(numero1==numero2){
            System.out.println("os dois numero são iguais");
        } else if (numero1>numero2) {
            System.out.println(numero1+" é o maior numero");

        }else {
            System.out.println(numero2+" é o maior numero");
        }
        entrada.close();
    }
}
