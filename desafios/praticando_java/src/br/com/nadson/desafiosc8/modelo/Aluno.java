package br.com.nadson.desafiosc8.modelo;

public class Aluno {
    private String nome;
    private int pontos;
    private Nivel nivel;

    public Aluno(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.nivel = Nivel.INICIANTE;
    }

    public void ganharPontos(int pontos) {
        if (pontos < 0) {
            System.out.println("Pontos inválidos.");
            return;
        }
        this.pontos += pontos;
        atualizarNivel();
    }

    public void perderPontos(int pontos) {
        if (pontos < 0) {
            System.out.println("Pontos inválidos.");
            return;
        }
        this.pontos -= pontos;
        if (this.pontos < 0) this.pontos = 0;
        atualizarNivel();
    }

    private void atualizarNivel() {
        if (pontos < 100) {
            nivel = Nivel.INICIANTE;
        } else if (pontos < 200) {
            nivel = Nivel.INTERMEDIARIO;
        } else if (pontos < 500) {
            nivel = Nivel.AVANCADO;
        } else {
            nivel = Nivel.MESTRE;
        }
    }

    public void exibirStatus() {
        System.out.println("Aluno: " + nome);
        System.out.println("Pontos: " + pontos);
        System.out.println("Nível: " + nivel);
    }

    public enum Nivel {
        INICIANTE,
        INTERMEDIARIO,
        AVANCADO,
        MESTRE
    }
}
