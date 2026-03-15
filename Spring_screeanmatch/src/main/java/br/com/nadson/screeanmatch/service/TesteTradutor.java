package br.com.nadson.screeanmatch.service;

public class TesteTradutor {

    public static void main(String[] args) {

        Tradutor tradutor = new Tradutor();

        String texto = """
                A group of vigilantes known as the Guardians
                protects the galaxy from cosmic threats.
                """;

        System.out.println("ORIGINAL:");
        System.out.println(texto);

        System.out.println("\nTRADUZIDO:");
        System.out.println(tradutor.traduzir(texto));
    }
}