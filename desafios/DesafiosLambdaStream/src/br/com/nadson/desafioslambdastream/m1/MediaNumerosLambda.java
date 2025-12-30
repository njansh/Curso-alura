package br.com.nadson.desafioslambdastream;

import java.util.Arrays;
import java.util.List;

public class MediaNumerosLambda {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        double media = numeros.stream()
                .mapToInt(n -> n)
                .average()
                .orElse(0.0);

        System.out.println("A média é: " + media);
    }
}