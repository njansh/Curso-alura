package br.com.nadson.desafiosc8.principal;

import br.com.nadson.desafiosc8.modelo.Conta;

public class ControleDeSaldoBancario {

	public static void main(String[] args) {
		Conta conta1=new Conta("Ana");
		conta1.exibirSaldo();
				conta1.depositar(1000);
		conta1.sacar(500);
conta1.sacar(600);
conta1.exibirSaldo();
System.out.println("-------------------");
        Conta conta2=new Conta("Bruno");
        conta2.exibirSaldo();
        conta2.depositar(2000);
        conta2.sacar(1500);
conta2.exibirSaldo();		
	}

}
