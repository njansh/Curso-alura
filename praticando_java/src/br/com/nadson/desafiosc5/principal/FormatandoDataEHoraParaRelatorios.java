package br.com.nadson.desafiosc5.principal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormatandoDataEHoraParaRelatorios {
    public static void main(String[] args) {

        LocalDate data = LocalDate.now();
        LocalTime hora = LocalTime.now();

        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String horaFormatada = hora.format(formatoHora);
        String dataFormatada = data.format(formatoData);

        System.out.println("Hora atual: " + horaFormatada);
        System.out.println("Data atual: " + dataFormatada);
    }
}
