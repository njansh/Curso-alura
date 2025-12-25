package br.com.nadson.minhasmusicas.modelo;

public class Audio {
    private String titulo;
    private int totalReproducao, curtidas;
    private int classificacao;

    public int getClassificacao() {
        return classificacao;
    }



    public int getCurtidas() {
        return curtidas;
    }

    public void curtir() {
        curtidas++;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotalReproducao() {
        return totalReproducao;
    }

    public void reproduzir() {
        this.totalReproducao ++;
    }
}
