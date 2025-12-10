package br.com.nadson.desafiosc9.modelo;

public abstract class OperacaoBancaria implements AcaoBancaria {
    private double valor;

    public OperacaoBancaria(double valor){
        this.valor=valor;
    }

    public double getValor() {
        return valor;
    }

}
