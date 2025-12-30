package br.com.nadson.desafioslambdastream.m1;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class MaiorNumeroLambda {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 5, 8, 20, 15);
        
        BinaryOperator<Integer> maiorNumero = (a, b) -> Integer.max(a, b);
        
        int resultado = numeros.stream()
                               .reduce(Integer.MIN_VALUE, maiorNumero);
        System.out.println("O maior número na lista é: " + resultado);
    }
}
