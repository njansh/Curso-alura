package br.com.nadson.desafiosc6.principal;

import java.util.List;

public class CalculandoOTotalComImposto {
    private static final double IMPOSTO = 0.08;

    public static void main(String[] args) {

        List<Double> precos = List.of(29.99, 49.90, 9.99, 4.99, 199.90, 299.90);

        double totalSemImposto = precos.stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        double totalComImposto = precos.stream()
                .mapToDouble(p -> p * (1 + IMPOSTO))
                .sum();

        System.out.printf("O total sem imposto é: %.2f%n", totalSemImposto);
        System.out.printf("O total com imposto é: %.2f%n", totalComImposto);
    }
}
