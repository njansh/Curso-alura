package br.com.nadson.desafiosc1.modelo;

public enum CategoriasLivros {
    FICCAO("Ficção"),
    NAO_FICCAO("Não-ficção"),
    TECNOLOGIA("Tecnologia"),
    HISTORIA("História");



    private final String descricao;

    CategoriasLivros(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
