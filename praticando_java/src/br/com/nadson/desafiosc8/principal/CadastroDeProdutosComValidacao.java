package br.com.nadson.desafiosc8.principal;

import br.com.nadson.desafiosc8.modelo.Produto;

public class CadastroDeProdutosComValidacao {
	public static void main(String[] args) {
		Produto produtoValido = new Produto("Notebook", 3500.00);
		System.out.println("Produto cadastrado com sucesso: " + produtoValido);
		
		Produto produtoInvalido = new Produto("Smartphone", -1500.00);
		System.out.println("Produto cadastrado com sucesso: " + produtoInvalido);
		
	}

}
