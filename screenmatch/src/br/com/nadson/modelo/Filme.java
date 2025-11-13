package br.com.nadson.modelo;

public class Filme {
    private String nome;
    private int anoDeLancamento;
    private double somaDasAvaliacoes;
    private boolean incluidoNoPlano;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

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

    void exibeFichaTecnica(){
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
}
