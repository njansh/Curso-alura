package com.nadson.ScreenSoundMusicas.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}