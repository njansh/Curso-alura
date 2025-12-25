package br.com.nadson.avaliacao.model;

import java.util.List;

public class Avaliacao <T>{
private T item;
private double avaliacao;
private String comentario;

    public Avaliacao(T item, double avaliacao, String comentario) {
        this.item = item;
        this.avaliacao = avaliacao;
        this.comentario = comentario;
    }

    public T getItem() {
        return item;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

public static <T> double mediaAvaliacoes(List<Avaliacao<T>> avaliacoes){
        return avaliacoes.stream().mapToDouble(Avaliacao::getAvaliacao).average().orElse(0.0);
}


    @Override
    public String toString() {
        return "Avaliacao{" +
               "item=" + item +
               ", avaliacao=" + avaliacao +
               ", comentario='" + comentario + '\'' +
               '}';
    }
}
