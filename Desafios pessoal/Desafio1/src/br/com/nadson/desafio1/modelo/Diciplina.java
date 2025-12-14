package br.com.nadson.desafio1.modelo;

public class Diciplina {
    private String nome;
    private Professor professor;
    private Aluno[] alunos;

    public Diciplina(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

}
