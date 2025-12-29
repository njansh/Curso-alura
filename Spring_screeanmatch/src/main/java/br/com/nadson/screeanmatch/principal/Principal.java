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
import java.util.Comparator;
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

    public Principal() {
        this.entrada = new Scanner(System.in);
        this.episodios = new ArrayList<>();
    }

    public void exibirMenu() {
        while (true) {
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
            String escolha = entrada.nextLine();
            if (escolha.equalsIgnoreCase("serie")) {
                System.out.println("Exibindo a série completa:");
                mostrarDadosSerie();
                System.out.println("O que deseja fazer a seguir?");
                System.out.println("1 - Ver o Top 5 episódios");
                System.out.println("2 - Filtrar episódios por ano");
                System.out.println("3 - Voltar ao menu principal");

                var opcao = entrada.nextInt();
                entrada.nextLine(); // Limpa o buffer

                if (opcao == 1) {
                    System.out.println("Top 5 episódios:");
                    System.out.println("\n--- TOP 5 EPISÓDIOS ---");
                    episodios.stream()
                            .sorted(java.util.Comparator.comparing(Episodio::getAvaliacao).reversed())
                            .limit(5)
                            .forEach(exibirEp);
                } else if (opcao == 2) {
                    filtrarPorAno();
                } else if (opcao == 3) {
                    continue;
                } else {
                    System.out.println("Opção inválida. Voltando ao menu principal.");
                    continue;
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

    private void filtrarPorAno() {
        System.out.println("A partir de que ano você deseja ver os episódios?");
        var ano = entrada.nextInt();
        entrada.nextLine();

        List<Episodio> episodioAno = episodios.stream()
                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().getYear() >= ano)
                .collect(Collectors.toList());

        if (episodioAno.isEmpty()) {
            var ultimoEpisodio = episodios.stream()
                    .filter(e -> e.getDataLancamento() != null)
                    .max(Comparator.comparing(Episodio::getDataLancamento));

            if (ultimoEpisodio.isPresent()) {
                var ep = ultimoEpisodio.get();
                System.out.println("Nenhum episódio encontrado para o ano digitado.");
                System.out.println("Esse é o último episódio: " + ep.getNome() + " (" + ep.getDataLancamento().getYear() + ")");
            } else {
                System.out.println("Nenhum episódio encontrado.");
            }
        } else {
            System.out.println("Episódios a partir de " + ano + ":");
            episodioAno.forEach(exibirEp);
        }
    }
}
