package br.com.nadson.desafiosc6.principal;

import java.util.List;

public class CalculandoEstatisticasDasNotas {
    public static void main(String[] args) {
        List<Double> notas= List.of(7.5,8.0,6.5,9.0,5.5,10.0,4.0);

        double soma= notas.stream().mapToDouble(Double::doubleValue).sum();
        double media= soma/notas.size();
        double menorNota=notas.stream().mapToDouble(Double::doubleValue).min().orElse(0);
        double maiorNota=notas.stream().mapToDouble(Double::doubleValue).max().orElse(0);

        System.out.println("A soma das notas é: "+soma);
        System.out.println("A média das notas é: "+String.format("%.2f",media));
        System.out.println("A menor nota é: "+menorNota);
        System.out.println("A maior nota é: "+maiorNota);
    }
}
