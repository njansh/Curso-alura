package br.com.nadson.minhasmusicas.principal;

import br.com.nadson.minhasmusicas.modelo.MinhasPreferidas;
import br.com.nadson.minhasmusicas.modelo.Musica;
import br.com.nadson.minhasmusicas.modelo.Podcast;

public class Principal {
    public static void main(String[] args) {
        Musica musica=new Musica();
        musica.setTitulo("NAO sei");
        musica.setCantor("Qualquer um");

        for (int i = 0;i <50 ; i++) {
            musica.curtir();
            i++;
        }
        for (int i = 0;i <10000 ; i++) {
            musica.reproduzir();
            i++;
        }

        Podcast podcast=new Podcast();
        podcast.setTitulo("Boladev");
        podcast.setHost("MArcus Mendes");

        for (int i = 0;i <1000 ; i++) {
            podcast.curtir();
            i++;
        }
        for (int i = 0;i <10000 ; i++) {
            podcast.reproduzir();
            i++;
        }

        MinhasPreferidas mp=new MinhasPreferidas();
        mp.incluir(podcast);
        mp.incluir(musica);
    }

}
