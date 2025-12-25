package br.com.nadson.desafiosc5.principal;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ConvertendoHorarioParaOutroFuso {

    public static void main(String[] args) {
ZonedDateTime horaLocal=ZonedDateTime.now();

DateTimeFormatter formato=DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada=horaLocal.format(formato);
       ZonedDateTime horaSydney=horaLocal.withZoneSameInstant(ZoneId.of("Australia/Sydney"));
       String horaSydneyF=horaSydney.format(formato);

        System.out.println("Hora local: "+horaFormatada);
        System.out.println("Hora Sydney: "+horaSydneyF);



    }

}
