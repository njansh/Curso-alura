package br.com.nadson.desafioslambdastream.m1;

import java.util.function.UnaryOperator;

public class TransformadorMaiusculasLambda {
    public static void main(String[] args) {
        UnaryOperator<String> paraMaiuscula=s->s.toUpperCase();
        String nome="Estou aqui";
        System.out.println("Nome em maiúsculas: " + paraMaiuscula.apply(nome));
    }
}
