package br.com.nadson.desafiosc1.modelo;

public class Pessoa {
   private String nome;
    private int idade;
    private double altura;
    private boolean estudante;


    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }



    public int getIdade() {
        return idade;
    }



    public double getAltura() {
        return altura;
    }



    public String isEstudante() {
        if(estudante){
            return "é estudande";
        }else{
        return "não é estudante"    ;
        }

    }

    public void setEstudante(boolean estudante) {
        this.estudante = estudante;
    }

    @Override
    public String toString() {
        return String.format( "Nome:%s \nIdade: %d anos \nAltura: %.2f metros \nEstudante:%s",getNome(),getIdade(),getAltura(),isEstudante());
    }
}
