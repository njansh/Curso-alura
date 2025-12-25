package br.com.nadson.desafiosc9.principal;

import br.com.nadson.desafiosc9.modelo.Boleto;
import br.com.nadson.desafiosc9.modelo.CartaoDeCredito;
import br.com.nadson.desafiosc9.modelo.Pagamento;
import br.com.nadson.desafiosc9.modelo.Pix;

import java.util.List;

public class SistemaDePagamentos {
    public static void main(String[] args) {
        List<Pagamento> pagamentos= List.of(
                new Boleto(400.00),
                new CartaoDeCredito(250.00),
                new Pix(300)
        );

      for (Pagamento pagamento : pagamentos) {
          pagamento.processarPagamento();
          System.out.println("-----");
      }}
}
