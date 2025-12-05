package br.com.nadson.desafiosc5.principal;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ControleDeExpediente {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            System.out.print("Digite o horário de entrada (HH:mm): ");
            LocalTime horaEntrada = LocalTime.parse(entrada.next(), formatter);

            System.out.print("Digite a carga horária diária (em horas): ");
            long cargaHoraria = entrada.nextLong();

            LocalTime saidaPrevista = horaEntrada.plusHours(cargaHoraria);

            System.out.print("Digite o horário de saída (HH:mm): ");
            LocalTime horaSaida = LocalTime.parse(entrada.next(), formatter);

            System.out.println("\nHorário de entrada:        " + horaEntrada);
            System.out.println("Saída prevista:            " + saidaPrevista);
            System.out.println("Saída real:                " + horaSaida);

            Duration diferenca = Duration.between(saidaPrevista, horaSaida);

            long horas = diferenca.toHours();
            long minutos = diferenca.toMinutesPart();

            String sinal;
            if (diferenca.isZero()) {
                sinal = "";
            } else if (diferenca.isNegative()) {
                sinal = "- ";
            } else {
                sinal = "+ ";
            }

            System.out.println(sinal + horas + "h " + minutos + "min");
        }
    }
}
