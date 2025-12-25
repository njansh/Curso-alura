package br.com.nadson.desafiosc7.modelo;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private List<Double> notas = new ArrayList<>();

    public Aluno(String nome) {
        this.nome = nome;
    }

    public void addNotas(double nota) {
        this.notas.add(nota);
    }

    public double getMedia() {
        return notas.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    public String situacao() {
        double media = getMedia();

        if (media >= 7) {
            return "Aprovado";
        } else if (media >= 5) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }

    public void exibirBoletim() {
        System.out.println("Aluno: " + nome);
        System.out.println("Notas: " + notas);
        System.out.printf("Média: %.1f%n", getMedia());
        System.out.println("Situação: " + situacao());
    }


}
