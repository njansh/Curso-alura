package br.com.nadson.desafioslambdastream;

import br.com.nadson.desafioslambdastream.interfaces.Calculadora;

public class CalculadoraLambda {
    public static void main(String[] args) {
        Calculadora calc=(a,b)->a*b;
        System.out.println("multiplicção dos numeros: "+calc.multiplicacao(3,5));

    }
}