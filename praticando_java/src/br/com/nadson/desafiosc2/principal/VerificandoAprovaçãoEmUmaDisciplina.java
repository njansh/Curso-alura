package br.com.nadson.desafiosc2.principal;

import br.com.nadson.desafiosc2.modelo.Aluno;

public class VerificandoAprovaçãoEmUmaDisciplina {
    public static void main(String[] args) {
        Aluno maria=new Aluno("Maria");
        maria.setNotas(10);
        maria.setNotas(10);
        maria.setNotas(7);
    Aluno joao=new Aluno("João");
    joao.setNotas(6);
    joao.setNotas(10);
    joao.setNotas(4);
    Aluno pedro=new Aluno("Pedro");
    pedro.setNotas(4);
    pedro.setNotas(3);
    pedro.setNotas(7);
    maria.situacao();
    joao.situacao();
    pedro.situacao();

    }
}
