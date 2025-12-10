package br.com.nadson.desafiosc9.modelo;

public class Sacar extends OperacaoBancaria{
    public Sacar(double valor) {
        super(valor);
    }

    @Override
    public void executar() {
        System.out.printf("\nSaque de valor R$%.2f realizado",getValor());
    }

}
