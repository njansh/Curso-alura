package br.com.nadson.desafiosc1.modelo;

import static br.com.nadson.desafiosc1.modelo.CategoriaProduto.ECONOMICO;

public class Produto {
    private String nome;
    private double preco;
    private CategoriaProduto categoria;


    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        definirCategoria();
    }

    private void definirCategoria() {
        if (preco < 50) {
            this.categoria=CategoriaProduto.ECONOMICO;
        } else if (preco <= 200) {   // intervalo contínuo
            this.categoria = CategoriaProduto.INTERMEDIARIO;
        } else {
            this.categoria = CategoriaProduto.PREMIUM;
        }
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return String.format(
                "Produto: %s\nPreço: %.2f\nCategoria: %s",
                nome, preco, categoria.getDescricao()
        );


}}
