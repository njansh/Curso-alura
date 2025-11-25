package br.com.nadson.screenmatch.modelo;

import com.google.gson.annotations.SerializedName;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
public class Titulo implements Comparable<Titulo> {
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int anoDeLancamento;
    private double somaDasAvaliacoes;
    private boolean incluidoNoPlano;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
    this.nome= meuTituloOmdb.title();
    this.anoDeLancamento=Integer.valueOf(meuTituloOmdb.year());
    this.duracaoEmMinutos=Integer.valueOf(meuTituloOmdb.runtime().substring(0,2));

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


    @Override
    public String toString() {
        return
                "nome='" + nome + '\'' +
                ", anoDeLancamento=" + anoDeLancamento +" duração em minutos "+duracaoEmMinutos+
                '}';
    }
}


