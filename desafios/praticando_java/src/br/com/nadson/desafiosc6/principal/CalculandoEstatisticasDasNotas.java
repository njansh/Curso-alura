
package br.com.nadson.desafiosc6.principal;

import java.util.DoubleSummaryStatistics;
import java.util.List;

public class CalculandoEstatisticasDasNotas {
    public static void main(String[] args) {
        final List<Double> notas = List.of(7.5, 8.0, 6.5, 9.0, 5.5, 10.0, 4.0);
        imprimirEstatisticas(notas);
    }

    private static void imprimirEstatisticas(List<Double> notas) {
        final DoubleSummaryStatistics stats = notas.stream()
                .mapToDouble(Double::doubleValue)
                .summaryStatistics();

        if (stats.getCount() == 0) {
            System.out.println("Nenhuma nota disponível.");
            return;
        }

        System.out.println("A soma das notas é: " + stats.getSum());
        System.out.printf( "A média das notas é: %.2f%n", stats.getAverage());
        System.out.println("A menor nota é: " + stats.getMin());
        System.out.println("A maior nota é: " + stats.getMax());
    }
}
