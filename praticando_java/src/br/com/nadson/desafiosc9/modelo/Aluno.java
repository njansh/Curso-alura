package br.com.nadson.desafiosc9.modelo;

public class Aluno  extends Pessoa {
private String tipoAluno;
private double nota;


public Aluno(String nome, int idade, double nota) {
	super(nome, idade);
	this.nota = nota;
	this.tipoAluno = "Regular";
	

}

public Aluno(String nome, String tipoAluno) {
	super(nome);
	this.tipoAluno = tipoAluno;
}



public void identificarAluno() {
    System.out.println("Nome do Aluno: " + getNome()+" - Tipo de Aluno: " + tipoAluno);
   
}
@Override
public String exibirDetalhes() {
    return super.exibirDetalhes() + ", Nota: " + nota;
}}