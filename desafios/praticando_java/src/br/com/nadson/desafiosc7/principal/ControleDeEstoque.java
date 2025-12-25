package br.com.nadson.desafiosc7.principal;

import br.com.nadson.desafiosc7.modelo.Estoque;

public class ControleDeEstoque {

    public static void main(String[] args) {

        Estoque produtoA = new Estoque("Produto A", 10);
        Estoque produtoB = new Estoque("Produto B", 5);

        realizarVendas(produtoA, 3, 8);
        realizarVendas(produtoB, 2, 4);
    }

    private static void realizarVendas(Estoque estoque, int... quantidades) {
        for (int quantidade : quantidades) {
            estoque.processarVenda(quantidade);
            System.out.println("-------------");
        }
    }
}
