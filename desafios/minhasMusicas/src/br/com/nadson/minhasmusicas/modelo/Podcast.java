package br.com.nadson.minhasmusicas.modelo;

public class Podcast extends Audio{
    private String host,descricao;

    public String getDescricao() {

        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public int getClassificacao() {
        if (getCurtidas()>500){


            return 10;
        }else {
            return 7;
        }
    }
}
