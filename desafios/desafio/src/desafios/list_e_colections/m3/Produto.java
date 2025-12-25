package desafios.list_e_colections.m3;

public class Produto {
    private double preco;
    private String nome;
    private double quantidade;
    private double total;

    public Produto(double preco, String nome, double quantidade) {
        this.preco = preco;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public double getTotal() {
        return getPreco()*getQuantidade();
    }
}
