package br.com.nadson.desafiosc8.principal;

import br.com.nadson.desafiosc8.modelo.Aluno;

public class SistemaDePontosParaAlunos {

    public static void main(String[] args) {

        Aluno aluno1 = new Aluno("Maria");
        aluno1.ganharPontos(250);
        aluno1.exibirStatus();

        System.out.println("-------------------");

        Aluno aluno2 = new Aluno("João");
        aluno2.ganharPontos(90);
        aluno2.exibirStatus();

        System.out.println("-------------------");

        Aluno aluno3 = new Aluno("Ana");
        aluno3.ganharPontos(150);
        aluno3.exibirStatus();
    }
}
