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

    @Transient
    private DadosSerie dadosSerie;


    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Episodio> episodios = new ArrayList<>();

    @Transient
    private static final Tradutor tradutor = new Tradutor();

    public Serie() {
    }

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
        this.episodios.forEach(e -> e.setSerie(this));
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

    public String getPoster() {
        return poster;
    }

    public DadosSerie getDadosSerie() {
        return dadosSerie;
    }

    public List<Episodio> getEpisodios() {
        return Collections.unmodifiableList(episodios);
    }
    public void setEpisodios(List<Episodio> episodios) {
        episodios.forEach(e -> e.setSerie(this));
        this.episodios = episodios;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
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