package br.com.nadson.screeanmatch.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Entity
@Table(name = "episodios")
public class Episodio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer temporada;
    private Integer numero;
    private Double avaliacao;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serie_id")
    private Serie serie;

    public Episodio() {
    }

    public Episodio(DadosEpisodio dados, Integer temporada) {
        this.nome = dados.titulo();
        this.temporada = temporada;
        this.numero = dados.numero();

        if (dados.dataLancamento() != null && !dados.dataLancamento().isBlank() && !dados.dataLancamento().equalsIgnoreCase("N/A")) {
            try {
                this.dataLancamento = LocalDate.parse(dados.dataLancamento());
            } catch (DateTimeParseException e) {
                this.dataLancamento = null;
            }
        } else {
            this.dataLancamento = null;
        }

        if (dados.avaliacao() != null && !dados.avaliacao().isBlank() && !dados.avaliacao().equalsIgnoreCase("N/A")) {
            try {
                this.avaliacao = Double.parseDouble(dados.avaliacao());
            } catch (NumberFormatException e) {
                this.avaliacao = 0.0;
            }
        } else {
            this.avaliacao = 0.0;
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getTemporada() {
        return temporada;
    }

    public Integer getNumero() {
        return numero;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "nome='" + nome + '\'' +
                ", temporada=" + temporada +
                ", numero=" + numero +
                ", avaliacao=" + avaliacao +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}