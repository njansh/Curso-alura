package br.com.nadson.desafiosc8.principal;

import br.com.nadson.desafiosc8.modelo.Bateria;

public class ControleDoNivelDeBateria {
	public static void main(String[] args) {
		
	
		Bateria bateria1 = new Bateria();
		bateria1.setNivelDeCarga(50);
		bateria1.carregar(30);
		System.out.println("Bateria 1: " + bateria1.mostrarNivelDeCarga());
		System.out.println(bateria1);

		System.out.println("----------------------------");

		Bateria bateria2 = new Bateria();
		bateria2.setNivelDeCarga(80);
		bateria2.usar(40);
		System.out.println("Bateria 2: " + bateria2.mostrarNivelDeCarga());
System.out.println(bateria2);
		System.out.println("----------------------------");

		Bateria bateria3 = new Bateria();
		bateria3.setNivelDeCarga(200);   
		System.out.println("Bateria 3: " + bateria3.mostrarNivelDeCarga());
System.out.println(bateria3);
		System.out.println("----------------------------");

		Bateria bateria4 = new Bateria();
		bateria4.setNivelDeCarga(-20);   
		System.out.println("Bateria 4: " + bateria4.mostrarNivelDeCarga());
System.out.println(bateria4);
	
	}
}
