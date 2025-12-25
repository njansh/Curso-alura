package br.com.nadson.desafiosc7.principal;

import br.com.nadson.desafiosc7.modelo.Colaborador;

public class CorrigindoOCadastro {
    public static void main(String[] args) {
        Colaborador colaborador = new Colaborador("Ana Silva", "Analista", 2);
        colaborador.atualizarDados("Gerente", 4);
        System.out.println("---------------------------------");
        Colaborador colaborador2 = new Colaborador("Carlos Souza", "Assistente", 1);
        colaborador2.atualizarDados("Coordenador", 3);
        System.out.println("---------------------------------");

        Colaborador colaborador3 = new Colaborador("Mariana Lima", "Estagiário", 0);
        colaborador3.atualizarDados("Analista Júnior", 1);


    }
}
