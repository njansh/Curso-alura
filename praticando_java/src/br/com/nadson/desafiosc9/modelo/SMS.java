package br.com.nadson.desafiosc9.modelo;

public class SMS extends Notificacao{
    public SMS(String destinatario, String mensagem) {
        super(destinatario, mensagem);
    }

    @Override
    public void enviarNotificacao() {
        System.out.println("Enviando SMS para " + this.getDestinatario() + "\nMensagem: " + this.getMensagem());
    }
}
