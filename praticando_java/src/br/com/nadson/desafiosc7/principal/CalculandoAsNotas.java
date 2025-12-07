package br.com.nadson.desafiosc7.principal;

import br.com.nadson.desafiosc7.modelo.Aluno;

public class CalculandoAsNotas {
    public static void main(String[] args) {
        Aluno maria = new Aluno("Maria");
        maria.addNotas(7.5);
        maria.addNotas(6.0);
        maria.addNotas(8.0);
        maria.exibirBoletim();

        Aluno joao = new Aluno("João");
        joao.addNotas(4.0);
        joao.addNotas(5.0);
        joao.addNotas(3.5);
        joao.exibirBoletim();

        Aluno ana = new Aluno("Ana");
        ana.addNotas(5.5);
        ana.addNotas(6.5);
        ana.addNotas(7.0);
        ana.exibirBoletim();
    }
}
