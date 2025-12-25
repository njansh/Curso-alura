package br.com.nadson.desafiosc9.modelo;

public class Pagamento {
    private double valor;
    private double taxa;

    public Pagamento(double valor) {
        this.valor = valor;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }


    public double calcularValorTaxa() {
        return (this.valor * this.taxa);
    }

    public void processarPagamento() {
        System.out.println("Processando pagamento de R$ " + String.format("%.2f",valor));
    }



}
