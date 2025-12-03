package br.com.nadson.desafiosc5.principal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormatandoDataEHoraParaRelatorios {
    public static void main(String[] args) {
        LocalDate data= LocalDate.now();
        LocalTime hora=LocalTime.now();
        String horaFormatada=hora.format(DateTimeFormatter.ofPattern("HH:mm"));
        String dataFormatada=data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Hora atual: "+horaFormatada);
        System.out.println("Data atual: "+dataFormatada);
    }
}
