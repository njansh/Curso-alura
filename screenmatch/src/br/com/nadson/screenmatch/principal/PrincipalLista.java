package br.com.nadson.screenmatch.principal;

import br.com.nadson.screenmatch.cauculadora.CalcularTempo;
import br.com.nadson.screenmatch.cauculadora.FiltroRecomendacao;
import br.com.nadson.screenmatch.modelo.Episodio;
import br.com.nadson.screenmatch.modelo.Filme;
import br.com.nadson.screenmatch.modelo.Series;
import br.com.nadson.screenmatch.modelo.Titulo;

import java.util.ArrayList;

public class PrincipalLista {
    public static void main(String[] args) {
        Filme avatarALendaDeAnng = new Filme("Avatar a lenda de anng", 2006);
avatarALendaDeAnng.avalia(9);

        Filme oPoderosoChefao = new Filme("O poderoso Chefao", 1970);
oPoderosoChefao.avalia(7);

        Filme matrix = new Filme("matrix", 1990);
matrix.avalia(8);

        System.out.println("A media de notas foi " + matrix.pegaMedia() + " Com " + matrix.getTotalDeAvaliacoes() + " Avaliações");

        Series doctorWho = new Series("Doctor Who", 2000);
//


        var lista = new ArrayList<Titulo>();
        lista.add(oPoderosoChefao);
        lista.add(avatarALendaDeAnng);
        lista.add(matrix);
        lista.add(doctorWho);

for(Titulo item:lista){
    System.out.println(item);

    if(item instanceof Filme filme && filme.getClassificacao()>2){
        System.out.println(((Filme) item).getClassificacao());
    }
}
    }



    }
