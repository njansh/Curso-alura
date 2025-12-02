package br.com.nadson.desafiosc2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private double media;
    private double somanota;
    private List<Double> notas=new ArrayList<>();

    public Aluno(String nome) {
        this.nome = nome;

    }

    public void setNotas(double nota) {
        this.notas.add(nota);
        somanota+=nota;
    }

    public double getMedia() {
        return media=somanota/notas.size();

    }

    public void situacao(){
        if(getMedia()>=5){
            if(getMedia()>=7){
                System.out.println(nome+" Esta aprovado(a) com media de "+getMedia());
            }else{
                System.out.println(nome+" Esta em recupeção com media de "+getMedia());
            }
        }else {
            System.out.println(nome+" Foi reprovado(a) com media de "+media);
        }
}

}
