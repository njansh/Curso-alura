package br.com.nadson.desafiosc9.modelo;

public class Email extends Notificacao{
    private String assunto;
    public Email(String destinatario, String mensagem, String assunto) {
        super(destinatario, mensagem);
        this.assunto = assunto;
    }

    @Override
    public void enviarNotificacao() {
        System.out.println("Enviando email para " + this.getDestinatario() + "\nAssunto: " + this.assunto + "\nCorpo: " + this.getMensagem());


}
}