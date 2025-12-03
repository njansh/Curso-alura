package br.com.nadson.desafiosc5.principal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DataEHoraAtual {
    public static void main(String[] args) {

        String tarefa = "Enviar relatório semanal";

        LocalDate data = LocalDate.now();
        LocalTime hora = LocalTime.now();

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("Tarefa: " + tarefa);
        System.out.println("Data atual: " + data.format(formatoData));
        System.out.println("Hora atual: " + hora.format(formatoHora));
    }
}
