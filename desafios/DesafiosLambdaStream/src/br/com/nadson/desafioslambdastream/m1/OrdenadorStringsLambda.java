package br.com.nadson.desafioslambdastream;

import java.util.Arrays;
import java.util.List;

public class OrdenadorStringsLambda {
    public static void main(String[] args) {
        List<String> frutas = Arrays.asList("Morango", "Abacaxi", "Zimbro", "Banana");

        frutas.sort(String::compareToIgnoreCase);
        System.out.println("Lista ordenada: " + frutas);
    }
}