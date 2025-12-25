package br.com.nadson.screenmatch.principal;

import br.com.nadson.screenmatch.cauculadora.FiltroRecomendacao;
import br.com.nadson.screenmatch.modelo.Episodio;
import br.com.nadson.screenmatch.modelo.Filme;
import br.com.nadson.screenmatch.modelo.Series;
import br.com.nadson.screenmatch.cauculadora.CalcularTempo;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme avatarALendaDeAnng=new Filme("Avatar a lenda de anng",2006);
      //  avatarALendaDeAnng.setNome("Avatar a lenda de anng");
      //  avatarALendaDeAnng.setAnoDeLancamento(2006);
        avatarALendaDeAnng.setDuracaoEmMinutos(90);
        avatarALendaDeAnng.setIncluidoNoPlano(true);
        avatarALendaDeAnng.avalia(10);
        avatarALendaDeAnng.avalia(10);
        avatarALendaDeAnng.avalia(10);

        Filme oPoderosoChefao=new Filme("O poderoso Chefao",1970);
       // oPoderosoChefao.setNome("o poderoso Chefao");
       // oPoderosoChefao.setAnoDeLancamento(1970);
        oPoderosoChefao.setDuracaoEmMinutos(80);
        oPoderosoChefao.setIncluidoNoPlano(true);
        oPoderosoChefao.avalia(10);
        oPoderosoChefao.avalia(10);
        oPoderosoChefao.avalia(10);

        Filme matrix=new Filme("matrix",1990);
        //matrix.setNome("Matrix");
       // matrix.setAnoDeLancamento(1990);
        matrix.setDuracaoEmMinutos(120);
        matrix.setIncluidoNoPlano(true);
        matrix.avalia(9);
        matrix.avalia(10);
        matrix.avalia(10);


        System.out.println("A media de notas foi "+matrix.pegaMedia()+" Com "+ matrix.getTotalDeAvaliacoes() +" Avaliações");

        Series doctorWho=new Series("Doctor Who",2000);
//        doctorWho.setNome("Doctor Who");
//        doctorWho.setAnoDeLancamento(2000);
        doctorWho.exibeFichaTecnica();
        doctorWho.setTemporadas(13);
        doctorWho.setMinutosPorEpisodio(70);
        doctorWho.setEpisodioPorTemporadas(20);

        System.out.println(doctorWho.getDuracaoEmMinutos());

        CalcularTempo calculador=new CalcularTempo();
        calculador.inclui(matrix);
        calculador.inclui(doctorWho);
        System.out.println(calculador.getTempoTotal());

        FiltroRecomendacao filtro=new FiltroRecomendacao();
        filtro.filtro(matrix);



        Episodio episodio=new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(doctorWho);
        episodio.setVisualizacoes(300);
        filtro.filtro(episodio);

        var filmes=new ArrayList<Filme>();
        filmes.add(oPoderosoChefao)   ;
        filmes.add(avatarALendaDeAnng);
        filmes.add(matrix);

        System.out.println("Tamanho da lista "+filmes.size());
        System.out.println(filmes.toString());
        System.out.println(filmes.get(0));
                }



    }
