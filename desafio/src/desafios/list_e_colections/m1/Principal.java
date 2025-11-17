package desafios.list_e_colections.m1;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pessoa ana=new Pessoa();
        ana.setNome("Ana");
        ana.setIdade(18);

        Pessoa pedro=new Pessoa();
        pedro.setNome("Pedro");
        pedro.setIdade(25);

        Pessoa joao=new Pessoa();
        joao.setNome("Joao");
        joao.setIdade(18);

        var pessoas=new ArrayList<Pessoa>();
        pessoas.add(ana);
        pessoas.add(pedro);
        pessoas.add(joao);
        System.out.println(pessoas.toString());
        System.out.println(pessoas.get(0));
        System.out.println(pessoas.size());
    }
}
