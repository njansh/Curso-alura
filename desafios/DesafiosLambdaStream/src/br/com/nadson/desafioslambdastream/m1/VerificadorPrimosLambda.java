package br.com.nadson.desafioslambdastream.m1;

import java.util.function.Predicate;

public class VerificadorPrimosLambda {
    public static void main(String[] args) {
        Predicate<Integer> isPrimo = n -> {
            if (n<=1){
                return false;
            }
            for (int i = 2; i <=    n/2 ; i++) {
                if(n%i==0){
                    return false;
                }

            }
            return true;
        };

        int numeroParaTeste = 4;
        System.out.println("O número " + numeroParaTeste + " é primo? " + isPrimo.test(numeroParaTeste));
    }
}