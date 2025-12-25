package br.com.nadson.desafiosc5.principal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CalculandoADataDeEntrega {
    public static void main(String[] args) {

        try (Scanner entrada = new Scanner(System.in)) {

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate dataInicial = null;


            while (dataInicial == null) {
                System.out.print("Informe a data inicial (dd/MM/yyyy): ");
                String input = entrada.nextLine();

                try {
                    dataInicial = LocalDate.parse(input, formato);
                } catch (DateTimeParseException e) {
                    System.out.println("Data inválida! Use o formato dd/MM/yyyy.");
                }
            }

            long diasDePrazo = -1;

            while (diasDePrazo < 0) {
                System.out.print("Informe o prazo de entrega em dias úteis (apenas números): ");

                if (entrada.hasNextLong()) {
                    diasDePrazo = entrada.nextLong();

                    if (diasDePrazo < 0) {
                        System.out.println("O prazo não pode ser negativo.");
                    }
                } else {
                    System.out.println("Entrada inválida! Digite somente números.");
                    entrada.next();
                }
            }

            LocalDate dataFinal = calcularDataUtil(dataInicial, diasDePrazo);

            System.out.println("Data final da entrega (dias úteis): " + dataFinal.format(formato));
        }
    }

    private static LocalDate calcularDataUtil(LocalDate dataInicial, long dias) {
        LocalDate data = dataInicial;
        long diasContados = 0;

        while (diasContados < dias) {
            data = data.plus(1, ChronoUnit.DAYS);

            DayOfWeek dia = data.getDayOfWeek();

            boolean diaUtil =
                    dia != DayOfWeek.SATURDAY &&
                            dia != DayOfWeek.SUNDAY;

            if (diaUtil) {
                diasContados++;
            }
        }

        return data;
    }
}
