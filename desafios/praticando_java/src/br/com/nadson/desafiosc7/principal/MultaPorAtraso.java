package br.com.nadson.desafiosc7.principal;

import br.com.nadson.desafiosc7.modelo.EmprestimoDeLivro;

import java.time.LocalDate;

public class MultaPorAtraso {
    public static void main(String[] args) {
        EmprestimoDeLivro emprestimo1 = new EmprestimoDeLivro("O Senhor dos Anéis", LocalDate.of(2024, 3, 12));
        emprestimo1.exibirDetalhesDoEmprestimo();
        emprestimo1.atrasoNoEmprestimo(LocalDate.of(2024, 3, 20));
        System.out.println("-----------------------------");
        EmprestimoDeLivro emprestimo2 = new EmprestimoDeLivro("1984", LocalDate.of(2024, 3, 12));
        emprestimo2.exibirDetalhesDoEmprestimo();
        emprestimo2.atrasoNoEmprestimo(LocalDate.of(2024, 3, 14));
        System.out.println("-----------------------------");

        EmprestimoDeLivro emprestimo3 = new EmprestimoDeLivro("A Guerra dos Tronos", LocalDate.of(2024, 3, 12));
        emprestimo3.exibirDetalhesDoEmprestimo();
        emprestimo3.atrasoNoEmprestimo(LocalDate.of(2024, 4, 1));

    }

}
