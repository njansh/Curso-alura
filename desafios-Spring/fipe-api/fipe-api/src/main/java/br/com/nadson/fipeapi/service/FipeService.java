package br.com.nadson.fipeapi.service;

import br.com.nadson.fipeapi.interfaces.IDataConverter;
import br.com.nadson.fipeapi.model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FipeService {
    private String tipoVeiculo;

    @Autowired
    private ApiConsumer apiConsumer;

    @Autowired
    private IDataConverter dataConverter;

    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";

    public void tipoVeiculo(int tipo) {
        switch (tipo) {
            case 1:
                this.tipoVeiculo = "carros";
                break;
            case 2:
                this.tipoVeiculo = "motos";
                break;

            case 3:
                this.tipoVeiculo = "caminhoes";
                break;
            default:
                this.tipoVeiculo = "carros";
                break;
        }
    }

    public List<Marca> listarMarcas() {
        String url = BASE_URL + tipoVeiculo + "/marcas";
        String json = apiConsumer.obterDados(url);
        return dataConverter.convertFromJson(json, new TypeReference<List<Marca>>() {
        });
    }

    public List<Modelo> listarModelos(String codigoMarca) {
        String url = BASE_URL + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos";
        String json = apiConsumer.obterDados(url);
        ModelosWrapper modelosWrapper = dataConverter.convertFromJson(json, ModelosWrapper.class);
        return modelosWrapper.modelos();
    }

    public List<Ano> listarAno(String codigoMarca, String codigoModelo){
        String url = BASE_URL + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos";
        String json = apiConsumer.obterDados(url);
        return dataConverter.convertFromJson(json, new TypeReference<List<Ano>>() {
        });

    }

    public Veiculo listarValorVeiculo(String codigoMarca, String codigoModelo, String codigoAno) {
        String url = BASE_URL + tipoVeiculo + "/marcas/" + codigoMarca
                + "/modelos/" + codigoModelo + "/anos/" + codigoAno;
        String json = apiConsumer.obterDados(url);
        return dataConverter.convertFromJson(json, Veiculo.class);
    }



}