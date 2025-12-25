package br.com.nadson.desafiosc7.modelo;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private  int paginas;


    public Livro(String titulo, String autor, int anoPublicacao, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.paginas = paginas;
    }

    public String getResumo() {
        return "O livro \"" + titulo + "\", escrito por " + autor +
               ", foi publicado em " + anoPublicacao+" e tem " + paginas + " páginas.";
    }
}
