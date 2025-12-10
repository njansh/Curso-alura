package br.com.nadson.desafiosc9.modelo;

public class Notificador {
    private String nome;
    private String mensagem;
    private int repeticoes;

    public void enviarMensagem(String nome, String mensagem, int repeticoes) {
        for (int i = 0; i < repeticoes; i++) {
            System.out.println("Enviando mensagem para " + nome + ": " + mensagem);

        }

    }

        public void enviarMensagem (String nome, String mensagem){

            System.out.println("Enviando mensagem para " + nome + ": " + mensagem);
        }

        public void enviarMenagem (String mensagem){
            System.out.println("Enviando mensagem: " + mensagem);
        }

    }

