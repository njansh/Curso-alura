package com.nadson.ScreenSoundMusicas.service;

import org.springframework.stereotype.Component;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

@Component
public class Conversor implements IConverteDados {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JacksonException e) {
            throw new RuntimeException("Erro ao converter JSON para a classe: " + classe.getSimpleName(), e);
        }
    }
}