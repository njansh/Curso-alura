package br.com.nadson.desafiosc2.principal;

import java.util.Scanner;

public class VerificandoSeUmNumeroEstaEmUmIntervalo {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        System.out.println("Digite o valor do emprestimo");
        double valor=entrada.nextDouble();
        if (valor>=1000&&valor<=5000){
            System.out.printf("o valor %.2f, esta dentro do intervalo permitido para emprestimo",valor);
        }else{  System.out.printf("o valor %.2f,não esta dentro do intervalo permitido para emprestimo",valor);
        }
    }

}
