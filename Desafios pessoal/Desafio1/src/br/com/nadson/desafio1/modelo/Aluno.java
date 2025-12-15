package br.com.nadson.desafio1.modelo;


public class Aluno extends Pessoa {
    private StatusAluno status = StatusAluno.ATIVO;
    private static int GERADOR_MATRICULA = 1;
    private final int matricula;

    public Aluno(String nome, int idade) {
        super(nome, idade);
        this.matricula = GERADOR_MATRICULA++;
    }


    public int getMatricula() {
        return matricula;
    }

    public StatusAluno getStatus() {
        return status;
    }

    public void trancar() {
        this.status = StatusAluno.TRANCADO;
    }
    public void formar() {
        this.status = StatusAluno.FORMADO;
    }
public void destrancar(){
        this.status = StatusAluno.ATIVO;
}

    @Override
    public String apresentar() {
        return String.format("Nome: %s, Idade: %d, Matricula: %d, Status: %s", getNome(), getIdade(), matricula, status);
    }
}
