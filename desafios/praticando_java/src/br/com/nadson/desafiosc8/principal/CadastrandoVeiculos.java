package br.com.nadson.desafiosc8.principal;

import br.com.nadson.desafiosc8.modelo.Carro;

public class CadastrandoVeiculos {

	public static void main(String[] args) {
Carro carro1 = new Carro("Toyota Corolla", "ABC-1234", 2020);
System.out.println("Carro cadastrado:");
System.out.println(carro1.getModelo());
System.out.println(carro1.getPlaca());
System.out.println(carro1.getAno());
Carro carro2 = new Carro("Honda Civic", "DEF-5678", 2019);
System.out.println("Carro cadastrado:");
System.out.println(carro2.getModelo());
System.out.println(carro2.getPlaca());
System.out.println(carro2.getAno());
		
	}

}
