package br.com.nadson.desafiosc9.modelo;

public class Luz implements Controlavel {
    private boolean ligado = false;

    @Override
    public void ligar() {
        if (!ligado) {
            ligado = true;

            System.out.println("Ligando a luz");
        } else {
            System.out.println("Luz já está ligada");
        }
    }

    @Override
    public void desligar() {
        if (ligado) {
            ligado = false;
            System.out.println("Desligando a luz");
        } else {
            System.out.println("A luz ja esta desligada");
        }

    }
}





