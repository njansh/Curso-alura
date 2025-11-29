package br.com.nadson.desafiosc1.modelo;
public enum CategoriaProduto {
    ECONOMICO("Econômico"),
    INTERMEDIARIO("Intermediário"),
    PREMIUM("Premium");

    private final String descricao;

    CategoriaProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
