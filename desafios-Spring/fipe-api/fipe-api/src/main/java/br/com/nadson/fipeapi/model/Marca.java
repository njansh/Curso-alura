package br.com.nadson.fipeapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Marca(
        @JsonAlias("codigo") String codigo,
        @JsonAlias("nome") String nome
) {}
