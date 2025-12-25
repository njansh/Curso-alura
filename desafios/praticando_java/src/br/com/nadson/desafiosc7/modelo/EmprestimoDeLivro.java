package br.com.nadson.desafiosc7.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EmprestimoDeLivro {

    private String nome;
    private LocalDate dataDeEntrega;
    private double valorMultaDiaria = 2.50; // multa padrão

    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public EmprestimoDeLivro(String nome, LocalDate dataDeEntrega) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do livro não pode estar vazio.");
        }

        if (dataDeEntrega == null) {
            throw new IllegalArgumentException("A data de entrega não pode ser nula.");
        }

        this.nome = nome;
        this.dataDeEntrega = dataDeEntrega;
    }

    public void setValorMultaDiaria(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor da multa diária deve ser maior que zero.");
        }
        this.valorMultaDiaria = valor;
    }

    public void exibirDetalhesDoEmprestimo() {
        System.out.println("Nome do livro: " + nome);
        System.out.println("Data de entrega: " + dataDeEntrega.format(FORMATADOR));
    }

    public boolean estaAtrasado(LocalDate dataAtual) {
        validarDataAtual(dataAtual);
        return dataAtual.isAfter(dataDeEntrega);
    }

    public void atrasoNoEmprestimo(LocalDate dataAtual) {

        validarDataAtual(dataAtual);

        if (dataAtual.isBefore(dataDeEntrega)) {
            System.out.println("O livro ainda não atingiu o prazo de entrega.");
            return;
        }

        if (dataAtual.isEqual(dataDeEntrega)) {
            System.out.println("Hoje é o último dia de entrega. Sem multa.");
            return;
        }

        long diasDeAtraso = ChronoUnit.DAYS.between(dataDeEntrega, dataAtual);
        double valorMulta = diasDeAtraso * valorMultaDiaria;

        System.out.println("O livro está atrasado!");
        System.out.println("Data de entrega: " + dataDeEntrega.format(FORMATADOR));
        System.out.println("Data atual: " + dataAtual.format(FORMATADOR));
        System.out.println("Dias de atraso: " + diasDeAtraso);
        System.out.printf("Multa diária: R$ %.2f%n", valorMultaDiaria);
        System.out.printf("Valor total da multa: R$ %.2f%n", valorMulta);
    }

    public double calcularMulta(LocalDate dataAtual) {

        validarDataAtual(dataAtual);

        if (!dataAtual.isAfter(dataDeEntrega)) {
            return 0.0;
        }

        long diasDeAtraso = ChronoUnit.DAYS.between(dataDeEntrega, dataAtual);
        return diasDeAtraso * valorMultaDiaria;
    }

    private void validarDataAtual(LocalDate dataAtual) {
        if (dataAtual == null) {
            throw new IllegalArgumentException("A data atual não pode ser nula.");
        }
    }
}
