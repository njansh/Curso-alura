package br.com.nadson.screenmatch.modelo;

public class Series extends Titulo{
   private int temporadas,
    episodioPorTemporadas,
    minutosPorEpisodio;
  boolean  ativa;

    public Series(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getEpisodioPorTemporadas() {
        return episodioPorTemporadas;
    }

    public void setEpisodioPorTemporadas(int episodioPorTemporadas) {
        this.episodioPorTemporadas = episodioPorTemporadas;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    @Override
    public int getDuracaoEmMinutos() {
        return temporadas*episodioPorTemporadas*minutosPorEpisodio;
    }

    @Override
    public String toString(){
        return "nome: "+this.getNome()+" ("+this.getAnoDeLancamento()+")";
    }
}
