package br.com.nadson.fipeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

// Usado para deserializar o JSON de modelos que vem com "modelos" e "anos"
@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelosWrapper(List<Modelo> modelos) {}
