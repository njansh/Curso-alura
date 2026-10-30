package br.com.nadson.screeanmatch.model;

import br.com.nadson.screeanmatch.enums.Categoria;
import br.com.nadson.screeanmatch.service.Tradutor;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;

    @Enumerated(EnumType.STRING)
    private Categoria genero;

    @Column(columnDefinition = "TEXT")
    private String sinopse;

    @Column(length = 1000)
    private String poster;

    @Column(length = 500)
    private String atores;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Episodio> episodios = new ArrayList<>();

    public Serie() {
    }

    public Serie(DadosSerie dadosSerie, List<Episodio> episodios) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();

        this.avaliacao = (dadosSerie.avaliacao() == null || dadosSerie.avaliacao().equalsIgnoreCase("N/A"))
                ? 0.0
                : Double.parseDouble(dadosSerie.avaliacao());

        this.genero = Categoria.fromString(dadosSerie.genero());
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();

        if (dadosSerie.sinopse() != null && !dadosSerie.sinopse().isBlank()) {
            this.sinopse = Tradutor.traduzir(dadosSerie.sinopse()).trim();
        } else {
            this.sinopse = "Sinopse não disponível";
        }

        setEpisodios(episodios);
    }

    public long getId() {
        return id;
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

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getPoster() {
        return poster;
    }

    public List<Episodio> getEpisodios() {
        return Collections.unmodifiableList(episodios);
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios == null ? new ArrayList<>() : new ArrayList<>(episodios);
        this.episodios.forEach(e -> e.setSerie(this));
    }

    @Override
    public String toString() {
        return "genero=" + genero +
                ", titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", avaliacao=" + avaliacao +
                ", atores='" + atores + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", poster='" + poster + '\'';
    }
}