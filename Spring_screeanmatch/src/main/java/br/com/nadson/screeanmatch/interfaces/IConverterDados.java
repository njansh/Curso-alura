package br.com.nadson.screeanmatch.interfaces;

public interface IConverterDados {
    <T> T obterDados(String json, Class<T> classe);

}
