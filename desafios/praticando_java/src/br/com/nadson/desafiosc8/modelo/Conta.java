package br.com.nadson.desafiosc8.modelo;

public class Conta {

    private String titular;
    private double saldo;

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Depósito inválido: valor deve ser maior que zero.");
            return;
        }
        saldo += valor;
        System.out.println("Depósito realizado: R$ " + valor + " | Novo saldo: R$ " + saldo);
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Saque inválido: valor deve ser maior que zero.");
            return;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para sacar R$ " + valor);
            return;
        }

        saldo -= valor;
        System.out.println("Saque realizado: R$ " + valor + " | Novo saldo: R$ " + saldo);
    }

    public void exibirSaldo() {
        System.out.println("Titular: " + titular + " | Saldo atual: R$ " + saldo);
    }
}
