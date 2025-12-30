package br.com.nadson.desafioslambdastream.m1;

import br.com.nadson.desafioslambdastream.m1.interfaces.VerificadorPalindromo;

public class VerificadorPalindromoLambda {
    public static void main(String[] args) {
        VerificadorPalindromo verificador = s -> {
            String invertida = new StringBuilder(s).reverse().toString();
       return s.equalsIgnoreCase(invertida);
        };
        VerificadorPalindromo simplificado = s -> s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());

        String palavra1 = "arara";
        String palavra2 = "hello";

        System.out.println("Usando 'verificador':");
        System.out.println("A palavra '" + palavra1 + "' é um palíndromo? " + verificador.verificarPalindromo(palavra1));
        System.out.println("A palavra '" + palavra2 + "' é um palíndromo? " + verificador.verificarPalindromo(palavra2));

        System.out.println("\nUsando 'simplificado':");
        System.out.println("A palavra '" + palavra1 + "' é um palíndromo? " + simplificado.verificarPalindromo(palavra1));
        System.out.println("A palavra '" + palavra2 + "' é um palíndromo? " + simplificado.verificarPalindromo(palavra2));
    }
}
