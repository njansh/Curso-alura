package br.com.nadson.desafiosc9.principal;

import br.com.nadson.desafiosc9.modelo.Email;
import br.com.nadson.desafiosc9.modelo.Notificacao;
import br.com.nadson.desafiosc9.modelo.Push;
import br.com.nadson.desafiosc9.modelo.SMS;

import java.util.List;

public class SistemaDeNotificacao {
    public static void main(String[] args) {
        List<Notificacao> notificacoes= List.of(
        new Email("nasdsonjhony@gmail.com", "Seu pedido foi enviado com sucesso!", "Confirmação de Pedido"),
        new SMS("+5511999999999", "Seu código de verificação é 123456"),
    new Push("Usuario123", "Você tem uma nova mensagem!", "Nova Mensagem")

               );

        for (Notificacao notificacao : notificacoes) {
            notificacao.enviarNotificacao();
            System.out.println("-----");
        }



    }}
