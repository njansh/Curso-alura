package br.com.nadson.desafiosc1.modelo;

public class Livro {
    private String titulo;
    private String autor;
    private int paginas;
    private double preco;
    private CategoriasLivros categoria;

    public Livro(String titulo, String autor, char tipo) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = validarCategoria(tipo);
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    private CategoriasLivros validarCategoria(char tipo) {
        tipo = Character.toUpperCase(tipo);

        return switch (tipo) {
            case 'F' -> CategoriasLivros.FICCAO;
            case 'N' -> CategoriasLivros.NAO_FICCAO;
            case 'T' -> CategoriasLivros.TECNOLOGIA;
            case 'H' -> CategoriasLivros.HISTORIA;
            default -> throw new IllegalArgumentException("Categoria inválida. Use F, N, T ou H.");
        };



    }

    @Override
    public String toString() {
        return String.format(
                "Título: %s%n" +
                        "Autor: %s%n" +
                        "Páginas: %d%n" +
                        "Preço: R$ %.2f%n" +
                        "Categoria: %s",
                titulo,
                autor,
                paginas,
                preco,
                categoria.getDescricao());
    }

}
