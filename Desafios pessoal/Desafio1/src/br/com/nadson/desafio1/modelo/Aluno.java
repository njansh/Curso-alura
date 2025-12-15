package br.com.nadson.desafio1.modelo;


import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private StatusAluno status = StatusAluno.ATIVO;
    private static int GERADOR_MATRICULA = 1;
    private final int matricula;
    private List<Disciplina> disciplinas;
    private List<Avaliacao> avaliacoes;

    public Aluno(String nome, int idade) {
        super(nome, idade);
        this.matricula = GERADOR_MATRICULA++;
        disciplinas=new ArrayList<>();
        avaliacoes =new ArrayList<>();
    }

    public void registrarDisciplina(Disciplina disciplina){
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina inválida");
        }

        if (status != StatusAluno.ATIVO) {
            throw new IllegalStateException("Aluno não está ativo");
        }

        if (disciplinas.contains(disciplina)) {
            throw new IllegalArgumentException("Disciplina já registrada");
        }

        disciplinas.add(disciplina);
    }

    public void registrarAvaliacao(Avaliacao avaliacao){
        if(avaliacao==null){
        throw new IllegalArgumentException("Avaliação inválida");
    }

        if (status != StatusAluno.ATIVO) {
            throw new IllegalStateException("Aluno não está ativo");
        }
        if(!disciplinas.contains(avaliacao.getDisciplina())){
            throw new IllegalArgumentException("O aluno nao esta matriculado nessa diciplina");
        }
        if (avaliacoes.contains(avaliacao)){
            throw new IllegalArgumentException("Avaliação já registrada");
        }
        avaliacoes.add(avaliacao);
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
