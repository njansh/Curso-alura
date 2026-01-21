package br.com.nadson.screeanmatch.principal;

import br.com.nadson.screeanmatch.model.DadosSerie;
import br.com.nadson.screeanmatch.model.DadosTemporada;
import br.com.nadson.screeanmatch.model.Episodio;
import br.com.nadson.screeanmatch.model.Serie;
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
    private final List<Serie> series = new ArrayList<>();
    private Serie serieAtual;
    private String nomeSerie;

    private static final String ENDERECO = "https://www.omdbapi.com/?t=";

    public void exibirMenu() {
        while (true) {
            System.out.println("\n--- BUSCA DE SÉRIES ---");

            int num = LeitorInteiro.ler("""
                    1 - Buscar série
                    2 - Listar séries
                    3 - Sair
                    """, entrada, 1, 3);

            switch (num) {
                case 1 -> buscarSerie();
                case 2 -> listarSeries();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void buscarSerie() {
        System.out.println("Diga o nome da serie: ");
        String nome = entrada.nextLine();
        if (nome != null && !nome.isBlank()) {
            nomeSerie = nome;
            if (carregarSerie()) {
                if (series.stream().noneMatch(s -> s.getDadosSerie().titulo().equalsIgnoreCase(serieAtual.getDadosSerie().titulo()))) {
                    series.add(serieAtual);
                    menuSerieEspecifica();
                }
                System.out.println("\nSérie '" + serieAtual.getDadosSerie().titulo() + "' adicionada com sucesso!");
            }
        } else {
            System.out.println("Nome da série não pode ser vazio.");
        }
    }

    private void listarSeries() {
        if (series.isEmpty()) {
            System.out.println("Nenhuma série encontrada.");
            return;
        }

        List<Serie> ordenadas = series.stream()
                .sorted(Comparator.comparing(s -> s.getDadosSerie().titulo(), String.CASE_INSENSITIVE_ORDER))
                .toList();

        System.out.println("\n--- SÉRIES CADASTRADAS ---");
        for (int i = 0; i < ordenadas.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, ordenadas.get(i).getDadosSerie().titulo());
        }

        int escolha = LeitorInteiro.ler(
                "\nDigite o número da série para acessar o menu específico (ou 0 para voltar):",
                entrada,
                0,
                ordenadas.size()
        );
    if(escolha > 0){
        serieAtual = ordenadas.get(escolha - 1);
        menuSerieEspecifica();
    }
    }

    public void menuSerieEspecifica() {
        boolean manterNaSerie = true;
        while (manterNaSerie) {
            System.out.println("\nMenu para: " + serieAtual.getDadosSerie().titulo());
            System.out.println("1 - Exibir todos os episódios");
            System.out.println("2 - Exibir Top 5 episódios");
            System.out.println("3 - Filtrar episódios por ano");
            System.out.println("4 - Buscar episódios de uma temporada");
            System.out.println("5 - Buscar um episódio pelo nome");
            System.out.println("6 - Exibir detalhes da série");
            System.out.println("7 - Voltar ao menu principal");


            int opcao = LeitorInteiro.ler("Escolha uma opção:", entrada, 1, 7);

            switch (opcao) {
                case 1 -> exibirSerieCompleta();
                case 2 -> exibirTop5();
                case 3 -> filtrarPorAno();
                case 4 -> buscarTemporadaEspecifica();
                case 5 -> escolher1Ep();
                case 6 -> exibirDetalhesSerie();
                case 7 -> manterNaSerie = false;
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void exibirDetalhesSerie() {
        System.out.println("\n--- DETALHES DA SÉRIE ---");
        System.out.println("Título: " + serieAtual.getDadosSerie().titulo());
        System.out.println("Ano de Lançamento: " + serieAtual.getDadosSerie().ano());
        System.out.println("Total de Temporadas: " + serieAtual.getDadosSerie().totalTemporadas());
        System.out.println("Avaliação (IMDB): " + serieAtual.getDadosSerie().avaliacao());
        System.out.println("Total de Episódios: " + serieAtual.getEpisodios().size());
        DoubleSummaryStatistics est = estatisticas(serieAtual.getEpisodios(), e -> true);
        System.out.printf("Média de Avaliação dos Episódios: %.2f%n", est.getAverage());
    }

    private boolean carregarSerie() {
        String jsonSerie = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+"));
        DadosSerie dados = conversor.obterDados(jsonSerie, DadosSerie.class);

        if (dados == null || dados.titulo() == null || dados.totalTemporadas() == null) {
            System.out.println("\n[!] Série não encontrada. Tente novamente.");
            return false;
        }

        List<Episodio> episodiosCarregados = carregarTodasAsTemporadas(dados);
        serieAtual = new Serie(dados, episodiosCarregados);
        return true;
    }

    private List<Episodio> carregarTodasAsTemporadas(DadosSerie dadosSerie) {
        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            String json = consumoApi.obterDados(
                    ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i);
            temporadas.add(conversor.obterDados(json, DadosTemporada.class));
        }

        return temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(e -> new Episodio(e, t.numero())))
                .collect(Collectors.toList());
    }

    private void exibirSerieCompleta() {
        System.out.println("\n--- EPISÓDIOS DA SÉRIE ---");

        var est = estatisticas(serieAtual.getEpisodios(), e -> true);
        System.out.printf("Média de nota: %.2f%n", est.getAverage());

        serieAtual.getEpisodios().forEach(this::imprimirEpisodio);
    }

    private void exibirTop5() {
        System.out.println("\n--- TOP 5 EPISÓDIOS ---");

        serieAtual.getEpisodios().stream()
                .filter(avaliacaoValida())
                .sorted(Comparator.comparing(Episodio::getAvaliacao).reversed())
                .limit(5)
                .forEach(this::imprimirEpisodio);
    }

    private void buscarTemporadaEspecifica() {
        int num = LeitorInteiro.ler(
                "Digite o número da temporada:",
                entrada,
                1,
                serieAtual.getDadosSerie().totalTemporadas()
        );

        var est = estatisticas(serieAtual.getEpisodios(), e -> e.getTemporada() == num);
        System.out.printf("Média da Temporada %d: %.2f%n", num, est.getAverage());

        serieAtual.getEpisodios().stream()
                .filter(daTemporada(num))
                .forEach(this::imprimirEpisodio);
    }

    private void filtrarPorAno() {
        int ano = LeitorInteiro.ler("A partir de que ano?", entrada);

        List<Episodio> filtrados = serieAtual.getEpisodios().stream()
                .filter(e -> e.getDataLancamento() != null &&
                        e.getDataLancamento().getYear() >= ano)
                .collect(Collectors.toList());

        if (filtrados.isEmpty()) {
            serieAtual.getEpisodios().stream()
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

        serieAtual.getEpisodios().stream()
                .filter(e -> nomeContemTodasAsPalavras(e, palavras))
                .findFirst()
                .ifPresentOrElse(
                        this::imprimirEpisodio,
                        () -> System.out.println("Episódio não encontrado.")
                );
    }

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
