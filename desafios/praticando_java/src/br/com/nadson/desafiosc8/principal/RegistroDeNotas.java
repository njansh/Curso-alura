package br.com.nadson.desafiosc8.principal;

import br.com.nadson.desafiosc8.modelo.Diciplina;

public class RegistroDeNotas {
	public static void main(String[] args) {
		Diciplina diciplina1=new Diciplina("Matemática");
		diciplina1.adicionarNota(8.5);
		diciplina1.adicionarNota(11.0);
		diciplina1.adicionarNota(7.0);
		diciplina1.adicionarNota(-2.0);
		diciplina1.exibirRelatorio();
		System.out.println("---------------");
		Diciplina diciplina2=new Diciplina("História");	
		diciplina2.adicionarNota(9.0);
		diciplina2.adicionarNota(6.5);
		diciplina2.adicionarNota(10.0);
		diciplina2.adicionarNota(12.0);
		diciplina2.exibirRelatorio();
		
		
	}

}
