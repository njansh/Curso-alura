package br.com.nadson.screeanmatch.controller;

import java.time.LocalDate;

public record EpisodioDTO(
        Long id,
        String titulo,
        Integer temporada,
        Integer numeroEpisodio,
        Double avaliacao,
        LocalDate dataLancamento
) {
}
