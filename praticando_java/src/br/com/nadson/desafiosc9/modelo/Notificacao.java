package br.com.nadson.desafiosc9.modelo;

public class Notificacao {


    private String destinatario, mensagem;

    public Notificacao(String destinatario, String mensagem) {
        this.destinatario = destinatario;
        this.mensagem = mensagem;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void enviarNotificacao(){
        System.out.println("Enviando notificação para "+this.destinatario+": "+this.mensagem);
    }
}
