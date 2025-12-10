package br.com.nadson.desafiosc9.modelo;

public class Pessoa {
	private String nome;
	private int idade;
	
	public Pessoa() {

	}

	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;

	}
	
	public String getNome() {
		return nome;
	}
	
	
	
	public int getIdade() {
		return idade;
	}
	
	public String exibirDetalhes() {
		return "Nome: " + nome + ", Idade: " + idade;
	}

}
