package br.com.nadson.desafio1.modelo;

public class Avaliacao {
    private double nota;
    private Diciplina diciplina;

    public Avaliacao(double nota, Diciplina diciplina) {
        this.nota = nota;
        this.diciplina = diciplina;
    }

    public double getNota() {
        return nota;
    }

    public Diciplina getDiciplina() {
        return diciplina;
    }

}
