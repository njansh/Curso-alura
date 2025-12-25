package br.com.nadson.desafiosc8.principal;

import br.com.nadson.desafiosc8.modelo.Filme;

public class AvaliacaoDeFilmes {
	public static void main(String[] args) {
		Filme filme1 = new Filme("Inception", 2010, "Christopher Nolan");
		filme1.adicionarNota(5);
		filme1.adicionarNota(4);
		filme1.adicionarNota(5);
		filme1.adicionarNota(3);
		filme1.adicionarNota(4);
		System.out.println(filme1);

		Filme filme2 = new Filme("The Matrix", 1999, "The Wachowskis");
		filme2.adicionarNota(5);
		filme2.adicionarNota(5);
		filme2.adicionarNota(4);
		filme2.adicionarNota(5);
		filme2.adicionarNota(5);
		System.out.println(filme2);

	}

}
