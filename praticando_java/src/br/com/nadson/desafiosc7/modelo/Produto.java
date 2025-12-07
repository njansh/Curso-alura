
package br.com.nadson.desafiosc7.modelo;

public class Produto {
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void imprimirRelatorio() {
        String rel = "Produto: " + nome + "\nPreço: " + String.format("R$ %.2f", preco) + "\nQuantidade: " + quantidade;
        System.out.println("-----------------------");
        System.out.println(rel);
    }
}
