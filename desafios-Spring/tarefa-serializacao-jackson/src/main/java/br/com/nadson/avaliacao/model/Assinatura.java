package br.com.nadson.avaliacao.model;

public class Assinatura {
    private static Long INCREMENT_ID = 0l;
    private final Long id;
    private String tipo;

    public Assinatura() {
        this.id = INCREMENT_ID++;
    }

    public Assinatura(String tipo) {
        this.id = INCREMENT_ID++;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Assinatura{" +
               "id=" + id +
               ", tipo='" + tipo + '\'' +
               '}';
    }
}
