package br.com.nadson.screeanmatch.exception;

public class LimiteRequisicoesExcedidoException extends RuntimeException {
    public LimiteRequisicoesExcedidoException(String mensagem) {
        super(mensagem);
    }
}