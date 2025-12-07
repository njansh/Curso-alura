
package br.com.nadson.desafiosc7.principal;

import br.com.nadson.desafiosc7.modelo.Produto;

import java.util.List;


public class RelatorioDoProduto {
    public static void main(String[] args) {
        final List<Produto> produtos = List.of(
                new Produto("Notebook", 3500.00, 10),
                new Produto("Smartphone", 2500.00, 5),
                new Produto("Tablet", 1500.00, 8)
        );
        System.out.println("Relatórios dos Produtos:");

        imprimirRelatorios(produtos);
    }

    private static void imprimirRelatorios(List<Produto> produtos) {
        if (produtos == null || produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível.");
            return;
        }

        produtos.forEach(Produto::imprimirRelatorio);
    }
}
