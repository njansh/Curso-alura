package br.com.nadson.desafiosc1.pricipal;

import br.com.nadson.desafiosc1.modelo.Pessoa;

public class DeclarandoValoresAVariáveis {
    public static void main(String[] args) {
        Pessoa pessoa=new Pessoa("Nadson",22,1.75);
        pessoa.setEstudante(true);
        System.out.println(pessoa);
    }
}
