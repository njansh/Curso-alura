package br.com.nadson.desafioslambdastream.m1;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class DesafioFinalStream {
    public static void main(String[] args) {
        List<Double> precos = Arrays.asList(5.0, 15.0, 20.0, 8.0, 30.0);
        Predicate<Double> maiorQue10= n->n>=10;
        UnaryOperator<Double>descont10=n->n*0.9;
        BinaryOperator<Double>somar=(a,b)->a+b;
        
        precos.stream().filter(maiorQue10).map(descont10).reduce(somar).ifPresent(
                total -> System.out.println("Soma dos preços com desconto: " + total)
        );
    }
}
