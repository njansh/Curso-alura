package br.com.nadson.desafiosc8.modelo;

public class Produto {
	private String nome;
	private double preco;

	public Produto(String nome, double preco) {
		this.nome = nome;
		if (validarPreco()) {
			this.preco = preco;
		} else {
			throw new IllegalArgumentException("Preço inválido: " + preco);
		}
		
	}
	
	public boolean validarPreco() {
		return preco >= 0;
	}
public String toString() {
        return nome + " - Preço: R$ " + String.format("%.2f", preco);
    }
}
