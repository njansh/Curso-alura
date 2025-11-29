package br.com.nadson.desafiosc1.pricipal;

import br.com.nadson.desafiosc1.modelo.Livro;

public class CadastroDeLivros {
    public static void main(String[] args) {
        Livro livro=new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 'f');
        livro.setPaginas(96);
        livro.setPreco(39.9);
        System.out.println(livro);
    }
}
