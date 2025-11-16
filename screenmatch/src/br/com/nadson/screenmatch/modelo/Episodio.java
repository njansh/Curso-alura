package br.com.nadson.screenmatch.modelo;

import br.com.nadson.screenmatch.cauculadora.Classificavel;

public class Episodio implements Classificavel {
        private int numero;
        private String nome;
        private Series serie;
        private int visualizacoes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Series getSerie() {
        return serie;
    }

    public void setSerie(Series serie) {
        this.serie = serie;
    }

    public int getVisualizacoes() {
        return visualizacoes;
    }

    public void setVisualizacoes(int visualizacoes) {
        this.visualizacoes = visualizacoes;
    }

    @Override
    public int getClassificacao() {
        if(visualizacoes>=400){
            return 4;
        }else {
            return 2;
        }
    }
}
