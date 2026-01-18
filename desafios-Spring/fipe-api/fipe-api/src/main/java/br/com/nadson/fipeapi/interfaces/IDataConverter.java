package br.com.nadson.fipeapi.interfaces;

import com.fasterxml.jackson.core.type.TypeReference;

public interface IDataConverter {
    <T> T convertFromJson(String json, Class<T> clazz);

    <T> T convertFromJson(String json, TypeReference<T> type);
}
