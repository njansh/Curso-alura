package br.com.nadson.desafiosc5.principal;

import java.time.Duration;
import java.time.LocalTime;

public class DiferençaEntreHoras {
    public static void main(String[] args) {
        LocalTime horaInicio= LocalTime.of(6, 50);
        LocalTime horaFinal=LocalTime.of(20, 25);
        Duration duracao=Duration.between(horaInicio,horaFinal);
        long horas=duracao.toHours();
        long minutos=duracao.toMinutesPart();
        System.out.println("A tarefa durou "+horas+" horas e "+minutos+" minutos.");

    }
}
