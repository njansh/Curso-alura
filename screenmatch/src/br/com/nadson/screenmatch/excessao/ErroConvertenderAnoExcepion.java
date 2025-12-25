package br.com.nadson.screenmatch.excessao;

public class ErroConvertenderAnoExcepion extends RuntimeException {
    private String mensagem;
    public ErroConvertenderAnoExcepion(String s) {
        this.mensagem=s;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }
}
