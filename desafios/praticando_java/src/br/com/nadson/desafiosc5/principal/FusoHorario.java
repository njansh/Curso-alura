package br.com.nadson.desafiosc5.principal;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FusoHorario {
    public static void main(String[] args) {
        ZonedDateTime horaTokyo=ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaTokyoF= horaTokyo.format(formato);
        System.out.println("Hora atual em Tokyo: "+horaTokyoF);
    }


}
