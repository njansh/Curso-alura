package br.com.nadson.desafiosc8.principal;

import java.util.ArrayList;
import java.util.List;

import br.com.nadson.desafiosc8.modelo.Contato;

public class AgendaDeContatos {
	public static void main(String[] args) {
		List<Contato> contatos = new ArrayList<>();
		Contato contato1 = new Contato("Alice", "1234-5678");
		Contato contato2 = new Contato("Bob", "8765-4321");
		Contato contato3 = new Contato("Charlie", "5555-6666");
	contatos.addAll((List.of(contato1, contato2, contato3)))	;
	int indice =1;
		System.out.println("Contatos cadastrados:");
		for (Contato contato : contatos) {
			System.out.println((indice++) + " - " + contato.toString());
		}
		
	}

}
