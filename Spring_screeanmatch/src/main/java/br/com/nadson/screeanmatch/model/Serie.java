package br.com.nadson.screeanmatch.model;

import br.com.nadson.screeanmatch.enums.Categoria;
import br.com.nadson.screeanmatch.service.Tradutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

public class Serie {

    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    private Categoria genero;
    private String atores;
    private String sinopse;
    private String poster;
    private final DadosSerie dadosSerie;
    private final List<Episodio> episodios;
    private static final Tradutor tradutor = new Tradutor();


    public Serie(DadosSerie dadosSerie, List<Episodio> episodios) {
        this.dadosSerie = dadosSerie;

        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();

        this.avaliacao = dadosSerie.avaliacao().equalsIgnoreCase("N/A")
                ? 0.0
                : Double.parseDouble(dadosSerie.avaliacao());

        this.genero = Categoria.fromString(dadosSerie.genero());
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();

        if (dadosSerie.sinopse() != null && !dadosSerie.sinopse().isBlank()) {
            this.sinopse = tradutor.traduzir(dadosSerie.sinopse()).trim();
        } else {
            this.sinopse = "Sinopse não disponível";
        }

        this.episodios = episodios == null
                ? new ArrayList<>()
                : new ArrayList<>(episodios);
    }
    public String getTitulo() {
        return titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public Categoria getGenero() {
        return genero;
    }

    public String getAtores() {
        return atores;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getPoster() {
        return poster;
    }

    public DadosSerie getDadosSerie() {
        return dadosSerie;
    }

    public List<Episodio> getEpisodios() {
        return Collections.unmodifiableList(episodios);
    }

    @Override
    public String toString() {
        return "genero=" + genero +
                ", titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", avaliacao=" + avaliacao +
                ", atores='" + atores + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", poster='" + poster + '\'' +
                ", episodios=" + episodios;
    }
}
