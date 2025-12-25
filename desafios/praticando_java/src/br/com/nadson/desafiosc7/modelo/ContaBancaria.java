package br.com.nadson.desafiosc7.modelo;

public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public void zerarSaldo() {
        this.saldo = 0;
    }

    public void exibirSaldo() {
    System.out.printf("O saldo atual é: R$ %.2f",saldo);
    }
}
