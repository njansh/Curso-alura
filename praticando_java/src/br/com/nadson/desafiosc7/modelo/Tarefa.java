package br.com.nadson.desafiosc7.modelo;

public class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    public void exibirStatus() {
        String status = concluida ? "Concluída" : "Pendente";
        System.out.println("Tarefa: " + descricao + " | Status: " + status);
    }
}
