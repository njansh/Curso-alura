package br.com.nadson.screeanmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpsodio(@JsonAlias("Title") String titulo,
                           @JsonAlias("Season") String temporada,
                           @JsonAlias("Episode") Integer numero,
                           @JsonAlias("imdbRating") String imdbRating,
                           @JsonAlias("Released") String dataLancamento) {
}
