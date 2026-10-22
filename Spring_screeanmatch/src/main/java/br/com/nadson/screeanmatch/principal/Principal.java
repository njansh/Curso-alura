
package br.com.nadson.screeanmatch.principal;

import br.com.nadson.screeanmatch.enums.Categoria;
import br.com.nadson.screeanmatch.exception.LimiteRequisicoesExcedidoException;
import br.com.nadson.screeanmatch.model.DadosSerie;
import br.com.nadson.screeanmatch.model.DadosTemporada;
import br.com.nadson.screeanmatch.model.Episodio;
import br.com.nadson.screeanmatch.model.Serie;
import br.com.nadson.screeanmatch.repository.EpisodioRepository;
import br.com.nadson.screeanmatch.repository.SerieRepository;
import br.com.nadson.screeanmatch.service.ConsumoApi;
import br.com.nadson.screeanmatch.service.ConverterDados;
import br.com.nadson.screeanmatch.service.Tradutor;
import br.com.nadson.screeanmatch.util.LeitorInteiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class Principal {

    @Autowired
    private ConsumoApi consumoApi;

    @Autowired
    private ConverterDados conversor;

    private final Scanner entrada = new Scanner(System.in);
    private Serie serieAtual;
    private String nomeSerie;

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private EpisodioRepository episodioRepository;

    private static final String ENDERECO = "https://www.omdbapi.com/?t=";

    public void exibirMenu() {
        while (true) {
            System.out.println("\n--- BUSCA DE SÉRIES ---");

            int num = LeitorInteiro.ler("""
                    1 - Buscar série
                    2 - Listar séries
                    3 - Buscar por categoria
                    4 - Buscar várias séries
                    5 - Corrigir sinopses com erro de tradução
                    6 - Sair
                    """, entrada, 1, 6);

            switch (num) {
                case 1 -> buscarSerie();
                case 2 -> listarSeries();
                case 3 -> buscarSeriePorCategoria();
                case 4 -> buscarVariasSeries();
                case 5 -> corrigirSinopsesComAviso();
                case 6 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void buscarSerie() {
        System.out.println("Diga o nome da serie: ");
        String nome = entrada.nextLine();
        buscarSeriePorNome(nome);

        if (serieAtual != null) {
            menuSerieEspecifica();
        }
    }

    private void buscarSeriePorNome(String nome) {
        if (nome == null || nome.isBlank()) {
            System.out.println("Nome da série não pode ser vazio.");
            return;
        }

        nomeSerie = nome;
        Optional<Serie> serieBuscada =
                serieRepository.findByTituloIgnoreCase(nomeSerie);

        if (serieBuscada.isPresent()) {
            serieAtual = serieBuscada.get();

            System.out.println("\nSérie '" + serieAtual.getTitulo()
                    + "' encontrada no banco de dados!");

            List<Episodio> episodiosBanco =
                    episodioRepository.findBySerie(serieAtual);

            if (episodiosBanco.isEmpty()) {
                System.out.println(
                        "Série sem episódios no banco. Baixando episódios automaticamente..."
                );
                atualizarEpisodiosDaSerie();
            }
        } else {
            System.out.println("\nSérie '" + nome
                    + "' não encontrada no banco. Buscando na API OMDb...");

            if (carregarSerie()) {
                if (serieAtual.getSinopse() != null
                        && !serieAtual.getSinopse().isBlank()) {

                    String sinopseTraduzida =
                            Tradutor.traduzir(serieAtual.getSinopse());

                    serieAtual.setSinopse(sinopseTraduzida);
                }

                serieRepository.save(serieAtual);

                System.out.println("Série '" + serieAtual.getTitulo()
                        + "' salva com sucesso no banco!");
            } else {
                System.out.println("A série '" + nome
                        + "' não foi encontrada na internet.");
                serieAtual = null;
            }
        }
    }

    private void buscarVariasSeries() {
        System.out.println(
                "Digite os nomes das séries separados por vírgula (ex: halo, teen wolf):"
        );

        String nomes = entrada.nextLine();

        if (nomes != null && !nomes.isBlank()) {
            List<String> listaNomes = Arrays.stream(nomes.split(","))
                    .map(String::trim)
                    .filter(n -> !n.isEmpty())
                    .toList();

            try {
                for (String nome : listaNomes) {
                    buscarSeriePorNome(nome);
                }
            } catch (LimiteRequisicoesExcedidoException e) {
                System.err.println("\n[AVISO CRÍTICO] " + e.getMessage());
                System.out.println(
                        "A busca em lote foi interrompida para preservar as séries já salvas."
                );
            }
        }
    }

    private void buscarSeriePorCategoria() {
        System.out.println("Digite a categoria/gênero para busca: ");
        var nomeGenero = entrada.nextLine();

        try {
            Categoria categoria = Categoria.fromString(nomeGenero);
            List<Serie> seriesPorCategoria =
                    serieRepository.findByGenero(categoria);

            if (seriesPorCategoria.isEmpty()) {
                System.out.println(
                        "Nenhuma série encontrada para a categoria " + categoria
                );
            } else {
                System.out.println(
                        "\n--- SÉRIES DA CATEGORIA " + categoria + " ---"
                );
                seriesPorCategoria.forEach(s ->
                        System.out.println(s.getTitulo()));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Categoria não reconhecida.");
        }
    }

    private void listarSeries() {
        List<Serie> seriesDoBanco = serieRepository.findAll();

        if (seriesDoBanco.isEmpty()) {
            System.out.println("Nenhuma série encontrada.");
            return;
        }

        Map<Categoria, List<Serie>> seriesPorCategoria =
                seriesDoBanco.stream()
                        .collect(Collectors.groupingBy(Serie::getGenero));

        System.out.println("\n--- SÉRIES CADASTRADAS POR CATEGORIA ---");

        seriesPorCategoria.forEach((categoria, lista) -> {
            System.out.println("\n" + categoria + ":");
            lista.forEach(s ->
                    System.out.printf("- %s%n", s.getTitulo()));
        });

        List<Serie> ordenadas = seriesDoBanco.stream()
                .sorted(Comparator.comparing(
                        Serie::getTitulo,
                        String.CASE_INSENSITIVE_ORDER
                ))
                .toList();

        System.out.println("\n--- LISTA COMPLETA ---");

        for (int i = 0; i < ordenadas.size(); i++) {
            System.out.printf("%d - %s%n",
                    i + 1, ordenadas.get(i).getTitulo());
        }

        int escolha = LeitorInteiro.ler(
                "\nDigite o número da série para acessar o menu específico (ou 0 para voltar):",
                entrada,
                0,
                ordenadas.size()
        );

        if (escolha > 0) {
            serieAtual = ordenadas.get(escolha - 1);
            menuSerieEspecifica();
        }
    }

    public void menuSerieEspecifica() {
        boolean manterNaSerie = true;

        while (manterNaSerie) {
            System.out.println("\nMenu para: " + serieAtual.getTitulo());
            System.out.println("1 - Exibir todos os episódios");
            System.out.println("2 - Exibir Top 5 episódios");
            System.out.println("3 - Filtrar episódios por ano");
            System.out.println("4 - Buscar episódios de uma temporada");
            System.out.println("5 - Buscar um episódio pelo nome");
            System.out.println("6 - Exibir detalhes da série");
            System.out.println("7 - Voltar ao menu principal");

            int opcao = LeitorInteiro.ler(
                    "Escolha uma opção:", entrada, 1, 7
            );

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
        System.out.println("Título: " + serieAtual.getTitulo());
        System.out.println("Gênero: " + serieAtual.getGenero());
        System.out.println("Total de Temporadas: "
                + serieAtual.getTotalTemporadas());
        System.out.println("Avaliação (IMDB): "
                + serieAtual.getAvaliacao());
        System.out.println("Atores: " + serieAtual.getAtores());
        System.out.println("Sinopse: " + serieAtual.getSinopse());

        List<Episodio> episodios =
                episodioRepository.findBySerie(serieAtual);

        System.out.println("Total de Episódios: " + episodios.size());

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));

        System.out.printf(
                "Média de Avaliação (dos %d episódios avaliados): %.2f%n",
                est.getCount(),
                est.getAverage()
        );
    }

    private boolean carregarSerie() {
        String jsonSerie = consumoApi.obterDados(
                ENDERECO + nomeSerie.replace(" ", "+")
        );

        if (jsonSerie != null
                && jsonSerie.contains("Request limit reached!")) {
            throw new LimiteRequisicoesExcedidoException(
                    "O limite diário de requisições da API OMDb foi atingido!"
            );
        }

        DadosSerie dados =
                conversor.obterDados(jsonSerie, DadosSerie.class);

        if (dados == null
                || dados.titulo() == null
                || dados.totalTemporadas() == null) {
            System.out.println("\n[!] Série não encontrada. Tente novamente.");
            return false;
        }

        List<Episodio> episodiosCarregados =
                carregarTodasAsTemporadas(dados);

        serieAtual = new Serie(dados, episodiosCarregados);
        return true;
    }

    private List<Episodio> carregarTodasAsTemporadas(DadosSerie dadosSerie) {
        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            String json = consumoApi.obterDados(
                    ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i
            );

            if (json != null
                    && json.contains("Request limit reached!")) {
                throw new LimiteRequisicoesExcedidoException(
                        "Limite diário atingido ao tentar baixar a temporada " + i
                );
            }

            DadosTemporada temporada =
                    conversor.obterDados(json, DadosTemporada.class);

            if (temporada != null && temporada.episodios() != null) {
                temporadas.add(temporada);
            }
        }

        return temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(e -> new Episodio(e, t.numero())))
                .collect(Collectors.toList());
    }

    private void exibirSerieCompleta() {
        System.out.println("\n--- EPISÓDIOS DA SÉRIE ---");

        List<Episodio> episodios =
                episodioRepository.findBySerie(serieAtual);

        if (episodios.isEmpty()) {
            System.out.println("Nenhum episódio cadastrado para esta série.");
            return;
        }

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));

        System.out.printf("Média de nota: %.2f%n", est.getAverage());
        episodios.forEach(this::imprimirEpisodio);
    }

    private void exibirTop5() {
        System.out.println("\n--- TOP 5 EPISÓDIOS ---");

        List<Episodio> top5 =
                episodioRepository.findTop5BySerieOrderByAvaliacaoDesc(serieAtual);

        if (top5.isEmpty()) {
            System.out.println("Nenhum episódio encontrado.");
            return;
        }

        top5.forEach(this::imprimirEpisodio);
    }

    private void buscarTemporadaEspecifica() {
        int num = LeitorInteiro.ler(
                "Digite o número da temporada:",
                entrada,
                1,
                serieAtual.getTotalTemporadas()
        );

        List<Episodio> episodiosTemporada =
                episodioRepository.findBySerieAndTemporada(serieAtual, num);

        if (episodiosTemporada.isEmpty()) {
            System.out.println(
                    "Nenhum episódio encontrado para a temporada " + num
            );
            return;
        }

        DoubleSummaryStatistics est = episodiosTemporada.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));

        System.out.printf("Média da Temporada %d: %.2f%n",
                num, est.getAverage());

        episodiosTemporada.forEach(this::imprimirEpisodio);
    }

    private void filtrarPorAno() {
        int ano = LeitorInteiro.ler("A partir de que ano?", entrada);

        List<Episodio> episodiosPorAno =
                episodioRepository.findEpisodesBySeriesAndYear(serieAtual, ano);

        if (episodiosPorAno.isEmpty()) {
            System.out.println(
                    "Nenhum episódio encontrado a partir do ano " + ano
            );
        } else {
            episodiosPorAno.forEach(this::imprimirEpisodioComData);
        }
    }

    private void escolher1Ep() {
        System.out.println("Digite um trecho do nome do episódio:");
        String trecho = entrada.nextLine();

        List<Episodio> encontrados =
                episodioRepository.findBySerieAndNomeContainingIgnoreCase(
                        serieAtual, trecho
                );

        if (encontrados.isEmpty()) {
            System.out.println("Episódio não encontrado.");
        } else {
            encontrados.forEach(this::imprimirEpisodio);
        }
    }

    private void imprimirEpisodio(Episodio e) {
        System.out.printf(
                "Temporada %-2d | Ep %-2d | Nota %-3.1f | %-30s%n",
                e.getTemporada(),
                e.getNumero(),
                e.getAvaliacao(),
                e.getNome()
        );
    }

    private void imprimirEpisodioComData(Episodio e) {
        System.out.printf(
                "Temporada %-2d | Ep %-2d | Data %s | Nota %-3.1f | %-30s%n",
                e.getTemporada(),
                e.getNumero(),
                e.getDataLancamento(),
                e.getAvaliacao(),
                e.getNome()
        );
    }

    private void atualizarEpisodiosDaSerie() {
        System.out.println("Baixando episódios da API, aguarde...");

        String jsonSerie = consumoApi.obterDados(
                ENDERECO + serieAtual.getTitulo().replace(" ", "+")
        );

        DadosSerie dados =
                conversor.obterDados(jsonSerie, DadosSerie.class);

        if (dados != null && dados.totalTemporadas() != null) {
            List<Episodio> novosEpisodios =
                    carregarTodasAsTemporadas(dados);

            novosEpisodios.forEach(e -> e.setSerie(serieAtual));

            episodioRepository.saveAll(novosEpisodios);

            System.out.println(
                    "Episódios atualizados com sucesso no banco de dados!"
            );
        } else {
            System.out.println(
                    "Não foi possível carregar as temporadas da API."
            );
        }
    }

    public void corrigirSinopsesComAviso() {
        List<Serie> seriesComErro =
                serieRepository.findBySinopseContainingIgnoreCase(
                        "MYMEMORY WARNING"
                );

        if (seriesComErro.isEmpty()) {
            System.out.println(
                    "Nenhuma série com erro de tradução encontrada no banco!"
            );
            return;
        }

        System.out.println(
                "\n--- CORRIGINDO SINOPSES COM LIMITE EXCEDIDO ---"
        );
        System.out.printf(
                "Total de séries a corrigir: %d%n%n",
                seriesComErro.size()
        );

        for (Serie serie : seriesComErro) {
            try {
                String json = consumoApi.obterDados(
                        ENDERECO + serie.getTitulo().replace(" ", "+")
                );

                if (json == null || json.contains("Request limit reached!")) {
                    throw new LimiteRequisicoesExcedidoException(
                            "Limite diário de requisições da OMDb atingido."
                    );
                }

                DadosSerie dados =
                        conversor.obterDados(json, DadosSerie.class);

                if (dados == null
                        || dados.sinopse() == null
                        || dados.sinopse().isBlank()) {
                    System.out.printf(
                            "[AVISO] Não foi possível obter a sinopse de: %s%n",
                            serie.getTitulo()
                    );
                    continue;
                }

                String novaSinopse = Tradutor.traduzir(dados.sinopse());

                if (novaSinopse == null
                        || novaSinopse.isBlank()
                        || novaSinopse.contains("MYMEMORY WARNING")) {
                    System.out.printf(
                            "[AVISO] Tradução inválida para: %s%n",
                            serie.getTitulo()
                    );
                    continue;
                }

                serie.setSinopse(novaSinopse);
                serieRepository.save(serie);

                System.out.printf(
                        "[OK] Sinopse corrigida: %s%n",
                        serie.getTitulo()
                );

            } catch (LimiteRequisicoesExcedidoException e) {
                System.err.println("\n[AVISO CRÍTICO] " + e.getMessage());
                System.out.println(
                        "Correção interrompida. As séries já corrigidas foram preservadas."
                );
                return;

            } catch (Exception e) {
                System.err.printf(
                        "[ERRO] Falha ao corrigir %s: %s%n",
                        serie.getTitulo(),
                        e.getMessage()
                );
            }
        }

        System.out.println("\nProcesso de correção finalizado!");
    }
}
