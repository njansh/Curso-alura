package br.com.nadson.desafioslambdastream.m1;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class SomaNumerosLambda {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40);

        BinaryOperator<Integer> soma = (a, b) -> a + b;

        int resultado = numeros.stream()
                .reduce(0, soma);

        System.out.println("A soma total é: " + resultado);
    }
}