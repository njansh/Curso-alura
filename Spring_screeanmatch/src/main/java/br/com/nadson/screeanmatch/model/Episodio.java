package br.com.nadson.screeanmatch.model;

import jakarta.persistence.*;

import java.time.LocalDate;
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
    private LocalDate dataLancamento;
    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    public Episodio() {
    }

    public Episodio(DadosEpisodio dados, Integer temporada){
        this.nome = dados.titulo();
        this.temporada =temporada;
        this.numero = dados.numero();
         try {
             this.dataLancamento = LocalDate.parse(dados.dataLancamento());
         }catch (Exception e){
             this.dataLancamento = null;
         }
         try {
             this.avaliacao = Double.parseDouble(dados.avaliacao());
             }catch (Exception e){
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
