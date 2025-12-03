package br.com.nadson.desafiosc5.principal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CalculandoADataDeEntrega {
    public static void main(String[] args) {

        try (Scanner entrada = new Scanner(System.in)) {

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.print("Informe a data inicial (dd/MM/yyyy): ");
            LocalDate dataInicial = LocalDate.parse(entrada.nextLine(), formato);

            System.out.print("Informe o prazo de entrega em dias úteis: ");
            long diasDePrazo = entrada.nextLong();

            LocalDate dataFinal = calcularDataUtil(dataInicial, diasDePrazo);

            System.out.println("Data final da entrega (dias úteis): " + dataFinal.format(formato));
        }
    }

    private static LocalDate calcularDataUtil(LocalDate dataInicial, long dias) {
        LocalDate data = dataInicial;
        long diasContados = 0;

        while (diasContados < dias) {
            data = data.plusDays(1);

            DayOfWeek diaDaSemana = data.getDayOfWeek();

            boolean diaUtil =
                    diaDaSemana != DayOfWeek.SATURDAY &&
                            diaDaSemana != DayOfWeek.SUNDAY;

            if (diaUtil) {
                diasContados++;
            }
        }

        return data;
    }
}
