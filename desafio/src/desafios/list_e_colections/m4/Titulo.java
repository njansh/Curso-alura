package desafios.list_e_colections.m4;


public class Titulo implements Comparable <Titulo>{
    private String nome;
    private double duracao;
private double nota;

    public String getNome() {
        return nome;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Titulo(String nome) {
        this.nome = nome;
    }



    @Override
    public int compareTo(Titulo o) {
        return this.getNome().compareTo(o.getNome());
    }


}
