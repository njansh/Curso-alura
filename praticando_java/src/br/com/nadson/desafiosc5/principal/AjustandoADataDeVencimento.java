package br.com.nadson.desafiosc5.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AjustandoADataDeVencimento {
    public static void main(String[] args) {

        LocalDate dataVencimento = LocalDate.of(2025, 2, 20);
        long adiantamento = 1;

        LocalDate novaDataVencimento = dataVencimento.plusMonths(adiantamento);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataFormatada = novaDataVencimento.format(formato);

        System.out.println("Nova data de vencimento: " + dataFormatada);
    }
}
