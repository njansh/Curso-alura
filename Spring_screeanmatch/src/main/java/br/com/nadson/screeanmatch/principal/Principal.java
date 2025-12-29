package br.com.nadson.screeanmatch.principal;

import br.com.nadson.screeanmatch.model.DadosEpisodio;
import br.com.nadson.screeanmatch.model.DadosSerie;
import br.com.nadson.screeanmatch.model.DadosTemporada;
import br.com.nadson.screeanmatch.model.Episodio;
import br.com.nadson.screeanmatch.service.ConsumoApi;
import br.com.nadson.screeanmatch.service.ConverterDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
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
    private List<Episodio> episodios;
    private Consumer<Episodio> exibirEp = e ->
            System.out.printf("Temporada %-2d | Ep: %-2d | Nota: %-3.1f | %-30s\n",
                    e.getTemporada(), e.getNumero(), e.getAvaliacao(), e.getNome());

    private final String ENDERECO = "https://www.omdbapi.com/?t=";

    public Principal(){
        this.entrada=new Scanner(System.in);
        this.episodios = new ArrayList<>();
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
                System.out.println("Exibindo a série completa:");
                mostrarDadosSerie();
                System.out.println("Você quer ver o top 5? (sim/não)");
                String top5Choice = entrada.nextLine();
                if (top5Choice.equalsIgnoreCase("sim")) {
                    System.out.println("Top 5 episódios:");
                    System.out.println("\n--- TOP 5 EPISÓDIOS ---");
                    episodios.stream()
                            .sorted(java.util.Comparator.comparing(Episodio::getAvaliacao).reversed())
                            .limit(5)
                            .forEach(exibirEp);
                }
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
        List<DadosTemporada> temporadas = new java.util.ArrayList<>();
        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            String json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i);
            DadosTemporada dadosDaTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosDaTemporada);
        }

        episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(e -> new Episodio(e, t.numero())))
                .collect(Collectors.toList());

        episodios.forEach(exibirEp);

    }

    private void mostrarDadosTemporadaEspecifica(int temporada) {
        String json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + temporada);
        DadosTemporada dadosDaTemporada = conversor.obterDados(json, DadosTemporada.class);
        if (dadosDaTemporada != null && dadosDaTemporada.episodios() != null) {
            System.out.println("Temporada " + dadosDaTemporada.numero() + ":");
            episodios = dadosDaTemporada.episodios().stream()
                    .map(e -> new Episodio(e, dadosDaTemporada.numero()))
                    .collect(Collectors.toList());


            episodios.forEach(exibirEp);
        } else {
            System.out.println("Temporada não encontrada ou sem episódios.");
        }
    }

    private String escolherSerie(String serie) {
        String json = consumoApi.obterDados(ENDERECO + serie.replace(" ", "+"));
        return json;
    }
}
