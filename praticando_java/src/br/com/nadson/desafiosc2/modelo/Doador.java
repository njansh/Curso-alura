package br.com.nadson.desafiosc2.modelo;

public class Doador {
    private String nome;
    private int idade;
    private double peso;

    public Doador(String nome, int idade, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
    }

    public void podeDoar() {

        boolean idadeValida = idade >= 18 && idade <= 65;
        boolean pesoValido = peso > 50;

        if (idadeValida && pesoValido) {
            System.out.println(nome + " está apto para doar sangue.");
            return;
        }

        System.out.println(nome + " não está apto para doar sangue.");
        System.out.print("Motivo: ");

        if (!idadeValida) {
            System.out.println("Deve ter entre 18 e 65 anos.");
        } else if (!pesoValido) {
            System.out.println("Deve pesar mais de 50 kg.");
        }
    }
}
