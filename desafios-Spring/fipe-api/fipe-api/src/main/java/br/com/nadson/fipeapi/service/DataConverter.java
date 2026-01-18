package br.com.nadson.fipeapi.service;

import br.com.nadson.fipeapi.interfaces.IDataConverter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class DataConverter implements IDataConverter {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T convertFromJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T convertFromJson(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
