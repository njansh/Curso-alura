package br.com.nadson.desafiosc9.modelo;

public class Boleto extends Pagamento {

    public Boleto(double valor) {
        super(valor);
        this.setTaxa(0.02);
    }

    @Override
    public void processarPagamento() {
        System.out.println("Processando pagamento com Boleto...");
        super.processarPagamento();
        System.out.println(" Valor taxa: R$ " + String.format("%.2f", calcularValorTaxa()));
    }


}
