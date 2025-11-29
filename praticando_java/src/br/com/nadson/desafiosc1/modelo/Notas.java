package br.com.nadson.desafiosc1.modelo;

public class Notas {
   private double nota1,nota2,nota3;
   private double media;

    public Notas(double nota1, double nota2, double nota3) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public double getNotas() {
        return nota1+nota2+nota3;
    }

    public double getMedia() {
        media=getNotas()/3;
        return media;
    }
}
