package br.com.nadson.avaliacao.model;

public class Servico {
    private static Long INCREMENT_ID = 0l;
    private final Long id;
    private String descricao;

    public Servico() {
        this.id = INCREMENT_ID++;
    }

    public Servico(String descricao) {
        this.id = INCREMENT_ID++;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Servico{" +
               "id=" + id +
               ", nome='" + descricao + '\'' +
               '}';
    }
}
