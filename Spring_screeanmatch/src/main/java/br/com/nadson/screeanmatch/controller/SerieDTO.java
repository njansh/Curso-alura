package br.com.nadson.screeanmatch.controller;

import br.com.nadson.screeanmatch.enums.Categoria;

public record SerieDTO(
        Long id,
        String titulo,
        Integer totalTemporadas,
        Double avaliacao,
        Categoria genero,
        String sinopse,
        String poster,
        String atores
) {

}
