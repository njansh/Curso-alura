package br.com.nadson.desafiosc9.principal;

import br.com.nadson.desafiosc9.modelo.Notificador;

public class EnviandoMensagens {
    public static void main(String[] args) {
        Notificador notificador = new Notificador();

        notificador.enviarMensagem("Alice", "Olá, Alice!", 3);
        System.out.println("-----");
        notificador.enviarMensagem("Bob", "Olá, Bob!");
        System.out.println("-----");
        notificador.enviarMenagem("Mensagem genérica para todos.");
    }
}
