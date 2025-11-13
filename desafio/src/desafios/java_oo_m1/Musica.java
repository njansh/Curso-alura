package desafios.java_oo_m1;

public class Musica {
    String titulo,artista;
    int anoDeLancamento,numAvaliacoes;
    double avaliacao;

    void fichaTecnica(){
        System.out.printf("O nome da musica é %s foi lançada em %d e é cantada por %s",titulo,anoDeLancamento,artista);
    }
void avaliar(double nota){
        avaliacao+=nota;
        numAvaliacoes++;

}
double getmedia(){
        return avaliacao/numAvaliacoes;
}
}
class Principal{
    public static void main(String[] args) {
Musica musica =new Musica();
musica.titulo="Era uma vez";
musica.artista="nao sei";
musica.anoDeLancamento=2019;
musica.fichaTecnica();
musica.avaliar(9);
        System.out.println("A media é "+musica.getmedia());
    }
}
