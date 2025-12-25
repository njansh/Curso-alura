package br.com.nadson.desafiosc7.modelo;

import java.util.ArrayList;
import java.util.List;

public class Compra {

    private List<Produto> produtos = new ArrayList<>();

    public void comprar(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        produtos.add(produto);
    }

    public void exibirResumoCompra() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto comprado.");
            return;
        }

        System.out.println("Produtos comprados:");
        produtos.forEach(Produto::imprimirRelatorio);

        System.out.printf("Total da compra: R$ %.2f%n", calcularTotal());
    }

    public double calcularTotal() {
        return produtos.stream()
                .mapToDouble(Produto::precoTotal)
                .sum();
    }
}
