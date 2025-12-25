package br.com.nadson.desafiosc9.modelo;

public class ArCondicionado implements Controlavel{
private boolean ligado=false;
@Override
public void ligar() {
    if (!ligado) {
        ligado = true;

        System.out.println("Ligando O Ar Condicionado");
    } else {
        System.out.println("O Ar condicionado ja esta ligado");
    }
}

@Override
public void desligar() {
    if (ligado) {
        ligado = false;
        System.out.println("Desligando o Ar Condicionado");
    } else {
        System.out.println("O Ar condicionado ja esta desligado");
    }

}}