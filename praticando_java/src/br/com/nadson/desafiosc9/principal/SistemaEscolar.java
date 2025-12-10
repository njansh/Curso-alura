package br.com.nadson.desafiosc9.principal;

import br.com.nadson.desafiosc9.modelo.Aluno;
import br.com.nadson.desafiosc9.modelo.Docente;

public class SistemaEscolar {
	public static void main(String[] args) {
		Aluno aluno1 = new Aluno("Maria", 20, 8.5);
		Aluno aluno2 = new Aluno("João", 22, 6.0);
		System.out.println(aluno1.exibirDetalhes());
        System.out.println(aluno2.exibirDetalhes());		
		Docente docente1 = new Docente("Dr. Silva", 45, "Matemática");
		Docente docente2 = new Docente("Prof. Souza", 38, "História");
		System.out.println(docente1.exibirDetalhes());
		System.out.println(docente2.exibirDetalhes());
	}

}
