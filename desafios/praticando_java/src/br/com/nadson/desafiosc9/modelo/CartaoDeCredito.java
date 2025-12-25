package br.com.nadson.desafiosc9.modelo;

public class CartaoDeCredito extends Pagamento {


    public CartaoDeCredito(double valor) {
        super(valor);
        setTaxa(0.05);
    }

    @Override

    public void processarPagamento() {
        System.out.println("Processando pagamento com Cartão de Crédito...");
        super.processarPagamento();
        System.out.println(" Valor taxa: R$ " + String.format("%.2f", calcularValorTaxa()));
    }

}
