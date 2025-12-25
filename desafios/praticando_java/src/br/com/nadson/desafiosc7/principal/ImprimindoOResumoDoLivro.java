   package br.com.nadson.desafiosc7.principal;

import br.com.nadson.desafiosc7.modelo.Livro;

import java.util.List;

public class ImprimindoOResumoDoLivro {
    public static void main(String[] args) {
        final List<Livro> livros = List.of(
                new Livro("1984", "George Orwell", 1949, 328),
                new Livro("To Kill a Mockingbird", "Harper Lee", 1960, 281),
                new Livro("The Great Gatsby", "F. Scott Fitzgerald", 1925, 180)
        );

        imprimirResumos(livros);
    }

    private static void imprimirResumos(final List<Livro> livros) {
        if (livros == null || livros.isEmpty()) {
            System.out.println("Nenhum livro disponível.");
            return;
        }

        for (Livro livro : livros) {
            System.out.println("--- Resumo do Livro ---");
            System.out.println(livro.getResumo());
        }
    }
}
