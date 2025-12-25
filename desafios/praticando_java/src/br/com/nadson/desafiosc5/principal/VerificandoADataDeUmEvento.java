package br.com.nadson.desafiosc5.principal;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class VerificandoADataDeUmEvento {
    public static void main(String[] args) {

        LocalDate dataEvento = LocalDate.of(2025, 10, 25);
        LocalDate dataAtual = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Data atual: " + dataAtual.format(formatter));
        System.out.println("Data do evento: " + dataEvento.format(formatter));

        if (dataEvento.isAfter(dataAtual)) {

            System.out.println("O evento ainda não aconteceu.");


            Period periodo = Period.between(dataAtual, dataEvento);
            System.out.println("Detalhe: faltam "
                    + periodo.getMonths() + " meses e "
                    + periodo.getDays() + " dias.");

        } else if (dataEvento.isBefore(dataAtual)) {
            System.out.println("O evento já aconteceu.");
        } else {
            System.out.println("O evento é hoje.");
        }
    }
}
