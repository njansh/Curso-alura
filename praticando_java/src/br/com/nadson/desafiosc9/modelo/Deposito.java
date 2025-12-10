package br.com.nadson.desafiosc9.modelo;

public class Deposito extends OperacaoBancaria{

    public Deposito(double valor) {
        super(valor);
    }

    @Override
    public void executar() {
        System.out.printf("\nDeposito de valor R$%.2f realizado",getValor());    }
}
