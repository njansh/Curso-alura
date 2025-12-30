package br.com.nadson.desafioslambdastream.m1;

import java.util.function.BiFunction;

public class DivisorNumerosLambda {
    public static void main(String[] args) {
        BiFunction<Double,Double,Double>divisao=(a,b)->{
          if(b==0){
              throw new ArithmeticException("Não é possível dividir por zero");
          }


            return a/b;
        };

        double resultado = divisao.apply(10.0, 2.0);
        System.out.println("O resultado da divisão é: " + resultado);
    }
}
