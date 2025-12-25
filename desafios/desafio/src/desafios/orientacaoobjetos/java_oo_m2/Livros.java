package desafios.orientacaoobjetos.java_oo_m2;

public class Livros {
 private String titulo,autor;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void exibirDetalhes(){
        System.out.println("O autor do liro "+titulo+" é "+autor);
    }
}
class Principal3 {
    public static void main(String[] args) {
        Livros l =new Livros();
        l.setAutor("Chico Duarte");
        l.setTitulo("O invasor");
        l.exibirDetalhes();
    }
}