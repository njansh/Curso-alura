package br.com.nadson.screeanmatch.principal;

import br.com.nadson.screeanmatch.model.DadosEpisodio;
import br.com.nadson.screeanmatch.model.DadosSerie;
import br.com.nadson.screeanmatch.model.DadosTemporada;
import br.com.nadson.screeanmatch.service.ConsumoApi;
import br.com.nadson.screeanmatch.service.ConverterDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
@Service
public class Principal {
    @Autowired
    private ConsumoApi consumoApi;
    @Autowired
    private ConverterDados conversor;
    private Scanner entrada;
    private String nomeSerie;
    private DadosSerie dadosSerie;
    private int numeroDaTemporada;

    private final String ENDERECO = "https://www.omdbapi.com/?t=";

    public Principal(){
        this.entrada=new Scanner(System.in);
    }
    public void exibirMenu(){
        while(true){
            System.out.println("Digite o nome da série para busca (ou 'sair' para encerrar):");
             nomeSerie = entrada.nextLine();

            if (nomeSerie.equalsIgnoreCase("sair")) {
                break;
            }

            String jsonSerie = escolherSerie(nomeSerie);
            dadosSerie = conversor.obterDados(jsonSerie, DadosSerie.class);

            if (dadosSerie.titulo() == null) { // Check if series data was successfully retrieved
                System.out.println("Série não encontrada.");
                continue;
            }

            System.out.println("Voce quer ver a serie como um todo ou por temporada? (serie/temporada)");
            String escolha= entrada.nextLine();
            if (escolha.equalsIgnoreCase("serie")) {
                mostrarDadosSerie();
            } else if (escolha.equalsIgnoreCase("temporada")) {
                System.out.println("Digite o número da temporada:");
                numeroDaTemporada = entrada.nextInt();
                entrada.nextLine();
                mostrarDadosTemporadaEspecifica(numeroDaTemporada);
            } else {
                System.out.println("Opção inválida. Exibindo a série completa.");
                mostrarDadosSerie();
            }
        }
    }

    private void mostrarDadosSerie() {
        System.out.println(dadosSerie);
        List<DadosTemporada> temporadas = obterTodasTemporadas();
        temporadas.forEach(System.out::println);
    }

    private void mostrarDadosTemporadaEspecifica(int temporada) {
        String json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + temporada);
        DadosTemporada dadosDaTemporada = conversor.obterDados(json, DadosTemporada.class);
        if (dadosDaTemporada != null && dadosDaTemporada.episodios() != null) {
            System.out.println("Temporada " + dadosDaTemporada.numero() + ":");
            dadosDaTemporada.episodios().stream()
                    .map(e -> new DadosEpisodio(
                            e.titulo(),
                            dadosDaTemporada.numero(),
                            e.numero(),
                            e.imdbRating(),
                            e.dataLancamento()
                    ))
                    .forEach(e -> System.out.println("  " + e.numero() + ". " + e.titulo()));
        } else {
            System.out.println("Temporada não encontrada ou sem episódios.");
        }
    }

    private List<DadosTemporada> obterTodasTemporadas() {
        List<DadosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            String json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i);
            DadosTemporada dadosDaTemporada = conversor.obterDados(json, DadosTemporada.class);
            List<DadosEpisodio> episodiosComTemporada =
                    dadosDaTemporada.episodios().stream()
                            .map(e -> new DadosEpisodio(
                                    e.titulo(),
                                    dadosDaTemporada.numero(),
                                    e.numero(),
                                    e.imdbRating(),
                                    e.dataLancamento()
                            ))
                            .collect(Collectors.toList());

            temporadas.add(
                    new DadosTemporada(dadosDaTemporada.numero(), episodiosComTemporada)
            );
        }
        return temporadas;
    }

    private String escolherSerie(String serie) {
        String json = consumoApi.obterDados(ENDERECO + serie.replace(" ", "+"));
        return json;
    }
}
