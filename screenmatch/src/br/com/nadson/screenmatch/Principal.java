package br.com.nadson.screenmatch;

import br.com.nadson.screenmatch.cauculadora.FiltroRecomendacao;
import br.com.nadson.screenmatch.modelo.Episodio;
import br.com.nadson.screenmatch.modelo.Filme;
import br.com.nadson.screenmatch.modelo.Series;
import br.com.nadson.screenmatch.cauculadora.CalcularTempo;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme=new Filme();
        meuFilme.setNome("o poderoso Chefao");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(80);
        meuFilme.setIncluidoNoPlano(true);
        meuFilme.avalia(10);
        meuFilme.avalia(10);
        meuFilme.avalia(10);

        System.out.println("A media de notas foi "+meuFilme.pegaMedia()+" Com "+ meuFilme.getTotalDeAvaliacoes() +" Avaliações");

        Series doctorWho=new Series();
        doctorWho.setNome("Doctor Who");
        doctorWho.setAnoDeLancamento(2000);
        doctorWho.exibeFichaTecnica();
        doctorWho.setTemporadas(13);
        doctorWho.setMinutosPorEpisodio(70);
        doctorWho.setEpisodioPorTemporadas(20);

        System.out.println(doctorWho.getDuracaoEmMinutos());

        CalcularTempo calculador=new CalcularTempo();
        calculador.inclui(meuFilme);
        calculador.inclui(doctorWho);
        System.out.println(calculador.getTempoTotal());

        FiltroRecomendacao filtro=new FiltroRecomendacao();
        filtro.filtro(meuFilme);



        Episodio episodio=new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(doctorWho);
        episodio.setVisualizacoes(300);
        filtro.filtro(episodio);



                }



    }
