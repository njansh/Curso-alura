package br.com.nadson.screeanmatch.principal;

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
            System.out.println("\n--- BUSCA DE SÉRIES ---");
            System.out.println("Digite o nome da série (ou 'sair'):");
            nomeSerie = entrada.nextLine();

            if (nomeSerie.equalsIgnoreCase("sair")) break;

            String jsonSerie = escolherSerie(nomeSerie);
            dadosSerie = conversor.obterDados(jsonSerie, DadosSerie.class);

// ESSA É A TRAVA DE SEGURANÇA:
            if (dadosSerie == null || dadosSerie.titulo() == null || dadosSerie.totalTemporadas() == null) {
                System.out.println("\n[!] Série não encontrada ou nome incorreto. Tente novamente.");
                continue; // Faz o código voltar para o "Digite o nome da série"
            }

// O código só chega aqui se a série for válida
            carregarTodasAsTemporadas();

            boolean manterNaSerie = true;
            while (manterNaSerie) {
                System.out.println("\nMenu para: " + dadosSerie.titulo());
                System.out.println("1 - Exibir todos os episódios");
                System.out.println("2 - Exibir Top 5 episódios");
                System.out.println("3 - Filtrar episódios por ano");
                System.out.println("4 - Buscar episódios de uma temporada específica");
                System.out.println("5 - Buscar outra série");

                var opcao = entrada.nextInt();
                entrada.nextLine(); // Limpa buffer

                switch (opcao) {
                    case 1 -> episodios.forEach(exibirEp);
                    case 2 -> exibirTop5();
                    case 3 -> filtrarPorAno();
                    case 4 -> buscarTemporadaEspecifica();
                    case 5 -> manterNaSerie = false;
                    default -> System.out.println("Opção inválida.");
                }
            }
        }
    }

    private void carregarTodasAsTemporadas() {
        List<DadosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            String json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i);
            DadosTemporada dadosDaTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosDaTemporada);
        }
        episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream().map(e -> new Episodio(e, t.numero())))
                .collect(Collectors.toList());
    }

    private void exibirTop5() {
        System.out.println("\n--- TOP 5 EPISÓDIOS ---");
        episodios.stream()
                .sorted(Comparator.comparing(Episodio::getAvaliacao).reversed())
                .limit(5)
                .forEach(exibirEp);
    }

    private void buscarTemporadaEspecifica() {
        System.out.println("Digite o número da temporada:");
        int num = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Episódios da Temporada " + num + ":");
        episodios.stream()
                .filter(e -> e.getTemporada() == num)
                .forEach(exibirEp);
    }

    private void filtrarPorAno() {
        System.out.println("A partir de que ano você deseja ver os episódios?");
        var ano = entrada.nextInt();
        entrada.nextLine();

        List<Episodio> filtrados = episodios.stream()
                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().getYear() >= ano)
                .collect(Collectors.toList());

        if (filtrados.isEmpty()) {
            episodios.stream()
                    .filter(e -> e.getDataLancamento() != null)
                    .max(Comparator.comparing(Episodio::getDataLancamento))
                    .ifPresentOrElse(
                            ep -> {
                                System.out.println("Nenhum encontrado. O último lançado foi: " +
                                        ep.getNome() + " em " + ep.getDataLancamento().getYear());
                            },
                            () -> System.out.println("Nenhum episódio com data encontrado.")
                    );
        } else {
            filtrados.forEach(exibirEp);
        }
    }

    private String escolherSerie(String serie) {
        return consumoApi.obterDados(ENDERECO + serie.replace(" ", "+"));
    }
}