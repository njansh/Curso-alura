package br.com.nadson.screeanmatch.principal;

import br.com.nadson.screeanmatch.model.DadosSerie;
import br.com.nadson.screeanmatch.model.DadosTemporada;
import br.com.nadson.screeanmatch.model.Episodio;
import br.com.nadson.screeanmatch.service.ConsumoApi;
import br.com.nadson.screeanmatch.service.ConverterDados;
import br.com.nadson.screeanmatch.util.LeitorInteiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class Principal {

    @Autowired
    private ConsumoApi consumoApi;
    @Autowired
    private ConverterDados conversor;

    private final Scanner entrada = new Scanner(System.in);
    private List<Episodio> episodios = new ArrayList<>();
    private DadosSerie dadosSerie;
    private String nomeSerie;

    private static final String ENDERECO = "https://www.omdbapi.com/?t=";

    /* ========================= MENU ========================= */

    public void exibirMenu() {
        while (true) {
            System.out.println("\n--- BUSCA DE SÉRIES ---");
            System.out.println("Digite o nome da série (ou 'sair'):");
            nomeSerie = entrada.nextLine();

            if (nomeSerie.equalsIgnoreCase("sair")) break;

            if (!carregarSerie()) continue;

            boolean manterNaSerie = true;
            while (manterNaSerie) {
                System.out.println("\nMenu para: " + dadosSerie.titulo());
                System.out.println("1 - Exibir todos os episódios");
                System.out.println("2 - Exibir Top 5 episódios");
                System.out.println("3 - Filtrar episódios por ano");
                System.out.println("4 - Buscar episódios de uma temporada");
                System.out.println("5 - Buscar um episódio pelo nome");
                System.out.println("6 - Buscar outra série");

                int opcao = LeitorInteiro.ler("Escolha uma opção:", entrada, 1, 6);

                switch (opcao) {
                    case 1 -> exibirSerieCompleta();
                    case 2 -> exibirTop5();
                    case 3 -> filtrarPorAno();
                    case 4 -> buscarTemporadaEspecifica();
                    case 5 -> escolher1Ep();
                    case 6 -> manterNaSerie = false;
                    default -> System.out.println("Opção inválida.");
                }
            }
        }
    }

    /* ========================= CARREGAMENTO ========================= */

    private boolean carregarSerie() {
        String jsonSerie = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+"));
        dadosSerie = conversor.obterDados(jsonSerie, DadosSerie.class);

        if (dadosSerie == null || dadosSerie.titulo() == null || dadosSerie.totalTemporadas() == null) {
            System.out.println("\n[!] Série não encontrada. Tente novamente.");
            return false;
        }

        carregarTodasAsTemporadas();
        return true;
    }

    private void carregarTodasAsTemporadas() {
        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            String json = consumoApi.obterDados(
                    ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i);
            temporadas.add(conversor.obterDados(json, DadosTemporada.class));
        }

        episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(e -> new Episodio(e, t.numero())))
                .collect(Collectors.toList());
    }

    /* ========================= EXIBIÇÃO ========================= */

    private void exibirSerieCompleta() {
        System.out.println("\n--- EPISÓDIOS DA SÉRIE ---");

        var est = estatisticas(episodios, e -> true);
        System.out.printf("Média de nota: %.2f%n", est.getAverage());

        episodios.forEach(this::imprimirEpisodio);
    }

    private void exibirTop5() {
        System.out.println("\n--- TOP 5 EPISÓDIOS ---");

        episodios.stream()
                .filter(avaliacaoValida())
                .sorted(Comparator.comparing(Episodio::getAvaliacao).reversed())
                .limit(5)
                .forEach(this::imprimirEpisodio);
    }

    private void buscarTemporadaEspecifica() {
        int num = LeitorInteiro.ler("Digite o número da temporada:",entrada);


        if (num < 1 || num > dadosSerie.totalTemporadas()) {
            System.out.println("Temporada inválida. Esta série possui " + dadosSerie.totalTemporadas() + " temporadas.");
            return;
        }

        var est = estatisticas(episodios, e -> e.getTemporada() == num);
        System.out.printf("Média da Temporada %d: %.2f%n", num, est.getAverage());

        episodios.stream()
                .filter(daTemporada(num))
                .forEach(this::imprimirEpisodio);
    }

    private void filtrarPorAno() {
        int ano = LeitorInteiro.ler("A partir de que ano?",entrada);

        List<Episodio> filtrados = episodios.stream()
                .filter(e -> e.getDataLancamento() != null &&
                        e.getDataLancamento().getYear() >= ano)
                .collect(Collectors.toList());

        if (filtrados.isEmpty()) {
            episodios.stream()
                    .filter(e -> e.getDataLancamento() != null)
                    .max(Comparator.comparing(Episodio::getDataLancamento))
                    .ifPresentOrElse(
                            e -> System.out.println("Último lançado: " +
                                    e.getNome() + " (" + e.getDataLancamento().getYear() + ")"),
                            () -> System.out.println("Nenhum episódio com data.")
                    );
        } else {
            filtrados.forEach(this::imprimirEpisodioComData);
        }
    }

    private void escolher1Ep() {
        System.out.println("Digite o nome do episódio:");
        String busca = entrada.nextLine().toLowerCase();
        String[] palavras = busca.split("\\s+");

        episodios.stream()
                .filter(e -> nomeContemTodasAsPalavras(e, palavras))
                .findFirst()
                .ifPresentOrElse(
                        this::imprimirEpisodio,
                        () -> System.out.println("Episódio não encontrado.")
                );
    }

    /* ========================= UTILITÁRIOS ========================= */

    private DoubleSummaryStatistics estatisticas(
            List<Episodio> lista, Predicate<Episodio> filtro) {

        return lista.stream()
                .filter(filtro)
                .filter(avaliacaoValida())
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
    }

    private Predicate<Episodio> avaliacaoValida() {
        return e -> e.getAvaliacao() > 0.0;
    }

    private Predicate<Episodio> daTemporada(int num) {
        return e -> e.getTemporada() == num;
    }

    private boolean nomeContemTodasAsPalavras(Episodio e, String[] palavras) {
        String nome = e.getNome().toLowerCase();
        return Arrays.stream(palavras).allMatch(p ->
                p.length() > 3 ? nome.contains(p) : nome.matches(".*\\b" + p + "\\b.*"));
    }

    private void imprimirEpisodio(Episodio e) {
        System.out.printf(
                "Temporada %-2d | Ep %-2d | Nota %-3.1f | %-30s%n",
                e.getTemporada(), e.getNumero(),
                e.getAvaliacao(), e.getNome());
    }

    private void imprimirEpisodioComData(Episodio e) {
        System.out.printf(
                "Temporada %-2d | Ep %-2d | Data %s | Nota %-3.1f | %-30s%n",
                e.getTemporada(), e.getNumero(),
                e.getDataLancamento(),
                e.getAvaliacao(), e.getNome());
    }
}


