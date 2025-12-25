package br.com.nadson.avaliacao.service;

import br.com.nadson.avaliacao.model.Avaliacao;

import java.util.List;

public class AvaliacaoService {

    public <T> double calcularMedia(List<Avaliacao<T>> avaliacoes) {
        return Avaliacao.mediaAvaliacoes(avaliacoes);
    }
}
