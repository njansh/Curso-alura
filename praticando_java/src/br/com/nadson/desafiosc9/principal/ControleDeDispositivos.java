package br.com.nadson.desafiosc9.principal;

import br.com.nadson.desafiosc9.modelo.ArCondicionado;
import br.com.nadson.desafiosc9.modelo.Luz;

public class ControleDeDispositivos {
    public static void main(String[] args) {
        Luz luz = new Luz();
        ArCondicionado arCondicionado = new ArCondicionado();
        luz.desligar();
        luz.ligar();

        luz.ligar();
        luz.desligar();

        System.out.println("\n---");
arCondicionado.ligar();
        arCondicionado.ligar();
        arCondicionado.desligar();
        arCondicionado.desligar();
    }
}
