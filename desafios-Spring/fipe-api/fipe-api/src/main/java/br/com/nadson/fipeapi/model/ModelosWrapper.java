package br.com.nadson.fipeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelosWrapper(List<Modelo> modelos) {}
