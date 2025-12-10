package br.com.nadson.desafiosc9.principal;

import br.com.nadson.desafiosc9.modelo.Aluno;
import br.com.nadson.desafiosc9.modelo.Bolsista;

public class IdentificandoOEstudante {
	public static void main(String[] args) {
	Aluno aluno1=new Aluno("João","Regular");
	Aluno aluno2=new Bolsista("Pedro");
	

	
	aluno1.identificarAluno();
	aluno2.identificarAluno();
		
	}

}
