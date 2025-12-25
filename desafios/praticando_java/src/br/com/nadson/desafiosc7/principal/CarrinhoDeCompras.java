package br.com.nadson.desafiosc7.principal;

import br.com.nadson.desafiosc7.modelo.Compra;
import br.com.nadson.desafiosc7.modelo.Produto;

public class CarrinhoDeCompras {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Notebook", 2500.00, 2);
        Produto produto2 = new Produto("Smartphone", 1500.00, 1);
        Produto produto3 = new Produto("Headphones", 300.00, 3);
        Compra compra = new Compra();
        compra.comprar(produto1);
        compra.comprar(produto2);
        compra.comprar(produto3);
        compra.exibirResumoCompra();
    }
}
