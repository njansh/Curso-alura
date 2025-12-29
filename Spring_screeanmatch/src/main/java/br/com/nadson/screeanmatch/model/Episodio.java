package br.com.nadson.screeanmatch.model;

import java.time.LocalDate;

public class Episodio {
    private String nome;
    private Integer temporada;
    private Integer numero;
    private Double avaliacao;
    private LocalDate dataLancamento;

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
