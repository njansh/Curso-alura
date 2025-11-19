package br.com.nadson.screenmatch.modelo;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoDeLancamento;
    private double somaDasAvaliacoes;
    private boolean incluidoNoPlano;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public String getNome() {
        return nome;
    }


    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

  public  void exibeFichaTecnica(){
        System.out.println("o nome do filme é "+nome);
        System.out.println("Ao ano de lancamento é "+anoDeLancamento);
        System.out.println("Duração em minutos"+duracaoEmMinutos);
        System.out.println("Esta incluido no plano? "+incluidoNoPlano);

    }

    public void avalia(double nota){
        somaDasAvaliacoes+=nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        double media=(somaDasAvaliacoes/totalDeAvaliacoes);
        return media;
    }

    @Override
    public int compareTo(Titulo outro) {
        return this.getNome().compareTo(outro.getNome());
    }
}
