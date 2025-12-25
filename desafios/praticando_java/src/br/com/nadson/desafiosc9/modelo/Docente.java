package br.com.nadson.desafiosc9.modelo;

public class Docente extends Pessoa {
	private String disciplina;
	
	public Docente(String nome, int idade, String disciplina) {
		super(nome, idade);
		this.disciplina = disciplina;
	}
	
	@Override
	public String exibirDetalhes() {
        return super.exibirDetalhes() + ", Disciplina: " + disciplina;		
	}

}
