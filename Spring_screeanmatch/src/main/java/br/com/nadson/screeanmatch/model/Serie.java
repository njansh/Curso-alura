package br.com.nadson.screeanmatch.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Serie {

    private final DadosSerie dadosSerie;
    private final List<Episodio> episodios;

    public Serie(DadosSerie dadosSerie, List<Episodio> episodios) {
        this.dadosSerie = dadosSerie;
        this.episodios = episodios == null ? new ArrayList<>() : new ArrayList<>(episodios);
    }

    public DadosSerie getDadosSerie() {
        return dadosSerie;
    }


    public List<Episodio> getEpisodios() {
        return Collections.unmodifiableList(episodios);
    }

    @Override
    public String toString() {
        String titulo = (dadosSerie != null && dadosSerie.titulo() != null) ? dadosSerie.titulo() : "N/D";
        int totalEps = episodios != null ? episodios.size() : 0;
        return "Serie{titulo='" + titulo + "', episodios=" + totalEps + "}";
    }
}
