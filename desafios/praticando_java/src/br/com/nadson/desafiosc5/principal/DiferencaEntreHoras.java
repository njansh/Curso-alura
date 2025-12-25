package br.com.nadson.desafiosc5.principal;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class DiferencaEntreHoras {
    public static void main(String[] args) {

        try (Scanner entrada = new Scanner(System.in)) {

            System.out.print("Digite a hora inicial (HH:MM): ");
            LocalTime horaInicio = LocalTime.parse(entrada.nextLine());

            System.out.print("Digite a hora final (HH:MM): ");
            LocalTime horaFim = LocalTime.parse(entrada.nextLine());

            if (horaFim.isBefore(horaInicio)) {
                horaFim = horaFim.plusHours(24);
            }

            Duration duracao = Duration.between(horaInicio, horaFim);

            long horas = duracao.toHours();
            long minutos = duracao.toMinutesPart();

            System.out.println(
                    String.format("A tarefa durou %d horas e %d minutos.", horas, minutos)
            );
        }
    }
}
