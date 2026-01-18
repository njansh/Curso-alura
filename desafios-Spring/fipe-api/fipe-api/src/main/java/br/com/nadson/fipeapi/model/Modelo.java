package br.com.nadson.fipeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record Modelo(String codigo, String nome) {}


