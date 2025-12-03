package br.com.nadson.desafiosc5.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LembreteDePagamento {
    public static void main(String[] args) {
        LocalDate dataVencimento = LocalDate.of(2025, 7, 26);
        long diasAtecedentes = 10;
        LocalDate dataAviso = dataVencimento.minusDays(diasAtecedentes);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("A data de aviso é: " + dataAviso.format(formato));

    }
}
