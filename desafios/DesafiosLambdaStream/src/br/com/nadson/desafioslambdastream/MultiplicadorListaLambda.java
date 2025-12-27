package br.com.nadson.desafioslambdastream;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class MultiplicadorListaLambda {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(4, 5, 3, 2, 56, 7, 6);
        UnaryOperator<Integer>multiplicar=n->n*3;
        System.out.println(numeros);
        numeros.replaceAll(multiplicar);
        System.out.println(numeros);
        numeros.stream().map(multiplicar).forEach(System.out::println);
    }
}
