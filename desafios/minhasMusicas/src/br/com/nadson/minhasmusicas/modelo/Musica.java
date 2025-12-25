package br.com.nadson.minhasmusicas.modelo;

public class Musica extends Audio{
    String album,cantor,genero;

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    @Override
    public int getClassificacao() {
        if (getTotalReproducao()>2000){

            return 10;
        }else {

            return 7;
        }
    }
}
