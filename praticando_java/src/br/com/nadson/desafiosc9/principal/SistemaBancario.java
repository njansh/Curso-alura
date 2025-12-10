package br.com.nadson.desafiosc9.principal;

import br.com.nadson.desafiosc9.modelo.Deposito;
import br.com.nadson.desafiosc9.modelo.OperacaoBancaria;
import br.com.nadson.desafiosc9.modelo.Sacar;

public class SistemaBancario {
    public static void main(String[] args) {
        OperacaoBancaria deposito= new Deposito(1000);
        OperacaoBancaria sacar=new Sacar(300);
        deposito.executar();
        sacar.executar();

    }

}
