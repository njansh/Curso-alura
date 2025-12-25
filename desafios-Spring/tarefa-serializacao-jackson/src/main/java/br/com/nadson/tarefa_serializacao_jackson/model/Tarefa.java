package br.com.nadson.tarefa_serializacao_jackson.model;

public class Tarefa {
    private String descricao;
    private boolean concluida;
    private String pessoaResponsavel;

    // Construtor padrão
    public Tarefa() {
    }

    // Construtor com parâmetros
    public Tarefa(String descricao, boolean concluida, String pessoaResponsavel) {
        this.descricao = descricao;
        this.concluida = concluida;
        this.pessoaResponsavel = pessoaResponsavel;
    }

    // Getters
    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public String getPessoaResponsavel() {
        return pessoaResponsavel;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
               "descricao='" + descricao + '\'' +
               ", concluida=" + concluida +
               ", pessoaResponsavel='" + pessoaResponsavel + '\'' +
               '}';
    }
}
