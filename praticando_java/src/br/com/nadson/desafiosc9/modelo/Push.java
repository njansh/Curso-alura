package br.com.nadson.desafiosc9.modelo;

public class Push extends Notificacao {
    private String titulo;

    public Push(String destinatario, String mensagem, String titulo) {
        super(destinatario, mensagem);
        this.titulo = titulo;
    }

    @Override
    public void enviarNotificacao() {
        System.out.println("Enviando Push para " + this.getDestinatario() + "\nTítulo: " + this.titulo + "\nConteudo: " + this.getMensagem());
    }


}