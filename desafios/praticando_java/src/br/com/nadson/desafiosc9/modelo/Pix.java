package br.com.nadson.desafiosc9.modelo;

public class Pix extends Pagamento {

    public Pix(double valor) {
        super(valor);
    }

    @Override
    public void processarPagamento() {
        System.out.println("Processando pagamento com Pix...");
        super.processarPagamento();
    }
}
