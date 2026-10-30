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

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private EpisodioRepository episodioRepository;

    private final Scanner entrada = new Scanner(System.in);
    private Serie serieAtual;

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
                    6 - Buscar serie pelo ator
                    7 - top 5 no banco
                    0- Sair
                    """, entrada, 0, 100);

            switch (num) {
                case 1 -> buscarSerie();
                case 2 -> listarSeries();
                case 3 -> buscarSeriePorCategoria();
                case 4 -> buscarVariasSeries();
                case 5 -> corrigirSinopsesComAviso();
                case 6 -> buscarSeriePorAtores();
                case 7 -> buscarTop5Series();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }



    private void buscarSerie() {
        System.out.println("Diga o nome da série: ");
        String nome = entrada.nextLine();
        buscarSeriePorNome(nome);

        if (serieAtual != null) {
            menuSerieEspecifica();
        }
    }

    private void buscarSeriePorNome(String nome) {
        if (nome == null || nome.isBlank()) {
            System.out.println("Nome da série não pode ser vazio.");
            serieAtual = null;
            return;
        }

        Optional<Serie> serieBuscada = serieRepository.findByTituloIgnoreCase(nome.trim());

        if (serieBuscada.isPresent()) {
            serieAtual = serieBuscada.get();
            System.out.println("\nSérie '" + serieAtual.getTitulo() + "' encontrada no banco de dados!");

            if (episodioRepository.findBySerie(serieAtual).isEmpty()) {
                System.out.println("Série sem episódios no banco. Baixando episódios automaticamente...");
                atualizarEpisodiosDaSerie();
            }
        } else {
            System.out.println("\nSérie '" + nome + "' não encontrada no banco. Buscando na API OMDb...");

            if (carregarNovaSerieDaApi(nome)) {
                serieRepository.save(serieAtual);
                System.out.println("Série '" + serieAtual.getTitulo() + "' salva com sucesso no banco!");
            } else {
                System.out.println("A série '" + nome + "' não foi encontrada na internet.");
                serieAtual = null;
            }
        }
    }

    private void buscarVariasSeries() {
        System.out.println("Digite os nomes das séries separados por vírgula (ex: halo, teen wolf):");
        String nomes = entrada.nextLine();

        if (nomes == null || nomes.isBlank()) return;

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
            System.out.println("A busca em lote foi interrompida para preservar as séries já salvas.");
        }
    }

    private void buscarSeriePorCategoria() {
        System.out.println("Digite a categoria/gênero para busca: ");
        String nomeGenero = entrada.nextLine();

        try {
            Categoria categoria = Categoria.fromString(nomeGenero);
            List<Serie> seriesPorCategoria = serieRepository.findByGenero(categoria);

            if (seriesPorCategoria.isEmpty()) {
                System.out.println("Nenhuma série encontrada para a categoria " + categoria);
            } else {
                System.out.println("\n--- SÉRIES DA CATEGORIA " + categoria + " ---");
                seriesPorCategoria.forEach(s -> System.out.println(s.getTitulo()));
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

        Map<Categoria, List<Serie>> seriesPorCategoria = seriesDoBanco.stream()
                .collect(Collectors.groupingBy(Serie::getGenero));

        System.out.println("\n--- SÉRIES CADASTRADAS POR CATEGORIA ---");
        seriesPorCategoria.forEach((categoria, lista) -> {
            System.out.println("\n" + categoria + ":");
            lista.forEach(s -> System.out.printf("- %s%n", s.getTitulo()));
        });

        List<Serie> ordenadas = seriesDoBanco.stream()
                .sorted(Comparator.comparing(Serie::getTitulo, String.CASE_INSENSITIVE_ORDER))
                .toList();

        System.out.println("\n--- LISTA COMPLETA ---");
        for (int i = 0; i < ordenadas.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, ordenadas.get(i).getTitulo());
        }

        int escolha = LeitorInteiro.ler(
                "\nDigite o número da série para acessar o menu específico (ou 0 para voltar):",
                entrada, 0, ordenadas.size()
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
            int opcao = LeitorInteiro.ler("""
                    1 - Exibir todos os episódios
                    2 - Exibir Top 5 episódios
                    3 - Filtrar episódios por ano
                    4 - Buscar episódios de uma temporada
                    5 - Buscar um episódio pelo nome
                    6 - Exibir detalhes da série
                    7 - Voltar ao menu principal
                    Escolha uma opção:
                    """, entrada, 1, 7);

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
        System.out.println("Total de Temporadas: " + serieAtual.getTotalTemporadas());
        System.out.println("Avaliação (IMDB): " + serieAtual.getAvaliacao());
        System.out.println("Atores: " + serieAtual.getAtores());
        System.out.println("Sinopse: " + serieAtual.getSinopse());

        List<Episodio> episodios = episodioRepository.findBySerie(serieAtual);
        System.out.println("Total de Episódios: " + episodios.size());
        exibirMediaAvaliacoes("Média geral dos episódios avaliados", episodios);
    }

    private void exibirSerieCompleta() {
        System.out.println("\n--- EPISÓDIOS DA SÉRIE ---");
        List<Episodio> episodios = episodioRepository.findBySerie(serieAtual);

        if (episodios.isEmpty()) {
            System.out.println("Nenhum episódio cadastrado para esta série.");
            return;
        }

        exibirMediaAvaliacoes("Média de nota da série", episodios);
        episodios.forEach(e -> imprimirEpisodio(e, false));
    }

    private void exibirTop5() {
        System.out.println("\n--- TOP 5 EPISÓDIOS ---");
        List<Episodio> top5 = episodioRepository.findTop5BySerieOrderByAvaliacaoDesc(serieAtual);

        if (top5.isEmpty()) {
            System.out.println("Nenhum episódio encontrado.");
            return;
        }

        top5.forEach(e -> imprimirEpisodio(e, false));
    }

    private void buscarTemporadaEspecifica() {
        int num = LeitorInteiro.ler(
                "Digite o número da temporada:",
                entrada, 1, serieAtual.getTotalTemporadas()
        );

        List<Episodio> episodiosTemporada = episodioRepository.findBySerieAndTemporada(serieAtual, num);

        if (episodiosTemporada.isEmpty()) {
            System.out.println("Nenhum episódio encontrado para a temporada " + num);
            return;
        }

        exibirMediaAvaliacoes("Média da Temporada " + num, episodiosTemporada);
        episodiosTemporada.forEach(e -> imprimirEpisodio(e, false));
    }
    private void buscarSeriePorAtores() {
        System.out.println("Digite o nome ou trecho do nome do ator:");
        String trecho = entrada.nextLine();

        if (trecho == null || trecho.isBlank()) {
            System.out.println("Nome do ator não pode ser vazio.");
            return;
        }

        String termo = trecho.trim();
        List<Serie> encontrados = serieRepository.findByAtoresContainingIgnoreCase(termo);

        if (encontrados.isEmpty()) {
            System.out.printf("Nenhuma série encontrada para o termo '%s'.%n", termo);
            return;
        }

        System.out.println("\n--- RESULTADOS ENCONTRADOS ---");

        encontrados.forEach(serie -> {
            String atorCorrespondente = Arrays.stream(serie.getAtores().split(","))
                    .map(String::trim)
                    .filter(ator -> ator.toLowerCase().contains(termo.toLowerCase()))
                    .findFirst()
                    .orElse(serie.getAtores());

                System.out.printf("- Série: %-25s | Ator: %-25s | Nota: %.1f%n",
                        serie.getTitulo(),
                        atorCorrespondente,
                        serie.getAvaliacao());
        });
    }

    private void buscarTop5Series() {
        List<Serie> seriesTop=serieRepository.findTop5ByOrderByAvaliacaoDesc();

        if (seriesTop.isEmpty()) {
            System.out.println("Nenhuma série cadastrada no banco.");
            return;
        }
        seriesTop.forEach(s -> {
                    System.out.printf("- Série: %-25s | Nota: %.1f%n",
                            s.getTitulo(),
                            s.getAvaliacao());
                }

                );




    }


    private void filtrarPorAno() {
        int ano = LeitorInteiro.ler("A partir de que ano?", entrada);
        List<Episodio> episodiosPorAno = episodioRepository.findEpisodesBySeriesAndYear(serieAtual, ano);

        if (episodiosPorAno.isEmpty()) {
            System.out.println("Nenhum episódio encontrado a partir do ano " + ano);
        } else {
            episodiosPorAno.forEach(e -> imprimirEpisodio(e, true));
        }
    }

    private void escolher1Ep() {
        System.out.println("Digite um trecho do nome do episódio:");
        String trecho = entrada.nextLine();

        List<Episodio> encontrados = episodioRepository.findBySerieAndNomeContainingIgnoreCase(serieAtual, trecho);

        if (encontrados.isEmpty()) {
            System.out.println("Episódio não encontrado.");
        } else {
            encontrados.forEach(e -> imprimirEpisodio(e, false));
        }
    }

    private void atualizarEpisodiosDaSerie() {
        System.out.println("Baixando episódios da API, aguarde...");
        DadosSerie dados = obterDadosSerieApi(serieAtual.getTitulo());

        if (dados != null) {
            List<Episodio> novosEpisodios = carregarTodasAsTemporadas(serieAtual.getTitulo(), dados.totalTemporadas());
            novosEpisodios.forEach(e -> e.setSerie(serieAtual));
            episodioRepository.saveAll(novosEpisodios);
            System.out.println("Episódios atualizados com sucesso no banco de dados!");
        } else {
            System.out.println("Não foi possível carregar as temporadas da API.");
        }
    }

    public void corrigirSinopsesComAviso() {
        List<Serie> seriesComErro = serieRepository.findBySinopseContainingIgnoreCase("MYMEMORY WARNING");

        if (seriesComErro.isEmpty()) {
            System.out.println("Nenhuma série com erro de tradução encontrada no banco!");
            return;
        }

        System.out.println("\n--- CORRIGINDO SINOPSES COM LIMITE EXCEDIDO ---");
        System.out.printf("Total de séries a corrigir: %d%n%n", seriesComErro.size());

        for (Serie serie : seriesComErro) {
            try {
                DadosSerie dados = obterDadosSerieApi(serie.getTitulo());

                if (dados == null || dados.sinopse() == null || dados.sinopse().isBlank()) {
                    System.out.printf("[AVISO] Não foi possível obter a sinopse de: %s%n", serie.getTitulo());
                    continue;
                }

                String novaSinopse = Tradutor.traduzir(dados.sinopse());

                if (novaSinopse == null || novaSinopse.isBlank() || novaSinopse.contains("MYMEMORY WARNING")) {
                    System.out.printf("[AVISO] Tradução inválida ou limite do tradutor atingido para: %s%n", serie.getTitulo());
                    continue;
                }

                serie.setSinopse(novaSinopse.trim());
                serieRepository.save(serie);
                System.out.printf("[OK] Sinopse corrigida: %s%n", serie.getTitulo());

            } catch (LimiteRequisicoesExcedidoException e) {
                System.err.println("\n[AVISO CRÍTICO] " + e.getMessage());
                System.out.println("Correção interrompida. As séries já corrigidas foram preservadas.");
                return;
            } catch (Exception e) {
                System.err.printf("[ERRO] Falha ao corrigir %s: %s%n", serie.getTitulo(), e.getMessage());
            }
        }

        System.out.println("\nProcesso de correção finalizado!");
    }

    // =========================================================================
    // MÉTODOS AUXILIARES
    // =========================================================================

    private boolean carregarNovaSerieDaApi(String nomeBusca) {
        DadosSerie dados = obterDadosSerieApi(nomeBusca);
        if (dados == null) {
            return false;
        }

        List<Episodio> episodiosCarregados = carregarTodasAsTemporadas(dados.titulo(), dados.totalTemporadas());
        serieAtual = new Serie(dados, episodiosCarregados);
        return true;
    }

    private DadosSerie obterDadosSerieApi(String titulo) {
        String json = requisitarJsonOmdb(ENDERECO + titulo.trim().replace(" ", "+"));
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

        if (dados == null || dados.titulo() == null || dados.totalTemporadas() == null) {
            return null;
        }
        return dados;
    }

    private List<Episodio> carregarTodasAsTemporadas(String titulo, int totalTemporadas) {
        List<DadosTemporada> temporadas = new ArrayList<>();
        String tituloFormatado = titulo.trim().replace(" ", "+");

        for (int i = 1; i <= totalTemporadas; i++) {
            String json = requisitarJsonOmdb(ENDERECO + tituloFormatado + "&season=" + i);
            DadosTemporada temporada = conversor.obterDados(json, DadosTemporada.class);

            if (temporada != null && temporada.episodios() != null) {
                temporadas.add(temporada);
            }
        }

        return temporadas.stream()
                .flatMap(t -> t.episodios().stream().map(e -> new Episodio(e, t.numero())))
                .collect(Collectors.toList());
    }

    private String requisitarJsonOmdb(String url) {
        String json = consumoApi.obterDados(url);
        if (json == null || json.contains("Request limit reached!")) {
            throw new LimiteRequisicoesExcedidoException("O limite diário de requisições da API OMDb foi atingido!");
        }
        return json;
    }

    private void exibirMediaAvaliacoes(String rotulo, List<Episodio> episodios) {
        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));

        System.out.printf("%s (%d avaliados): %.2f%n", rotulo, est.getCount(), est.getAverage());
    }

    private void imprimirEpisodio(Episodio e, boolean exibirData) {
        if (exibirData) {
            System.out.printf("Temporada %-2d | Ep %-2d | Data %s | Nota %-3.1f | %-30s%n",
                    e.getTemporada(), e.getNumero(), e.getDataLancamento(), e.getAvaliacao(), e.getNome());
        } else {
            System.out.printf("Temporada %-2d | Ep %-2d | Nota %-3.1f | %-30s%n",
                    e.getTemporada(), e.getNumero(), e.getAvaliacao(), e.getNome());
        }
    }
}