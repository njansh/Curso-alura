package br.com.nadson.fipeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Ano(String codigo, String nome) {}
