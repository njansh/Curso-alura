package br.com.nadson.desafioslambdastream.m1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ProcessadorStringsLambda {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "lambda", "stream", "programacao", "funcional");
        Predicate<String>maisDe3=s -> s.length()>=5;
        UnaryOperator<String>paraMaiusculo=s -> s.toUpperCase();
        palavras.stream().filter(maisDe3).map(paraMaiusculo).forEach(System.out::println);
    }

}
