package desafios.consumindoAPI.m3.excessoes;

public class SenhaInvalidaException extends RuntimeException {
    private String mensagem;
    public SenhaInvalidaException(String senhaInvalida) {
    this.mensagem=senhaInvalida;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }
}
