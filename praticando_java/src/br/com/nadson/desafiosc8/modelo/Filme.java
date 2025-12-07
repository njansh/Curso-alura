package br.com.nadson.desafiosc8.modelo;

import java.util.ArrayList;
import java.util.List;

public class Filme {

    private String titulo;
    private String diretor;
    private int ano;
    private List<Double> notas = new ArrayList<>();

    public Filme(String titulo, int ano, String diretor) {
        this.titulo = titulo;
        this.ano = ano;
        this.diretor = diretor;
    }

    public void adicionarNota(double nota) {
        if (validarNota(nota)) {
            notas.add(nota);
        } else {
            throw new IllegalArgumentException("Nota inválida: " + nota + ". Deve estar entre 0 e 5.");
        }
    }

    public double calcularMedia() {
        if (notas.isEmpty()) {
            return 0.0;
        }

        double soma = notas.stream()
                           .mapToDouble(Double::doubleValue)
                           .sum();

        return soma / notas.size();
    }

    private boolean validarNota(double nota) {
        return nota >= 0 && nota <= 5;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
               " (" + ano + ")" +
               ", Diretor: " + diretor +
               ", Média: " + String.format("%.2f", calcularMedia());
    }
}
