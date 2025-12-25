package br.com.nadson.avaliacao.model;

public class Produto {
    private static Long INCREMENT_ID = 0l;
    private final Long id;
    private String nome;

    public Produto() {
        this.id = INCREMENT_ID++;
    }

    public Produto( String nome) {
        this.id = INCREMENT_ID++;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    @Override
    public String toString() {
        return "Produto{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               '}';
    }
}
