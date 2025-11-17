package br.com.nadson.screenmatch.modelo;

import br.com.nadson.screenmatch.cauculadora.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public String getDiretor() {
        return diretor;
    }




    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int)pegaMedia()/2;
    }

    @Override
    public String toString() {
        return "Filme: "+this.getNome()+ " ("+this.getAnoDeLancamento()+" )";
    }
}
