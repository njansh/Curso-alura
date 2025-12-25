package br.com.nadson.desafiosc7.principal;

import br.com.nadson.desafiosc7.modelo.ContaBancaria;

public class ZerandoOSaldo {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("Ana Silva", 1500.00);
        System.out.println("Saldo antes de zerar: " );
                conta.exibirSaldo();
        conta.zerarSaldo();
        System.out.println("\nSaldo após zerar: " );
        conta.exibirSaldo();


    }
}
