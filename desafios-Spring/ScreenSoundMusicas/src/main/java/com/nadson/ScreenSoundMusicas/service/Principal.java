package com.nadson.ScreenSoundMusicas.service;

import br.com.nadson.screeanmatch.util.LeitorInteiro;
import com.nadson.ScreenSoundMusicas.domain.Artista;
import com.nadson.ScreenSoundMusicas.domain.Musica;
import com.nadson.ScreenSoundMusicas.enums.TipoArtista;
import com.nadson.ScreenSoundMusicas.repository.ArtistaRepository;
import com.nadson.ScreenSoundMusicas.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class Principal {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private MusicaRepository musicaRepository;
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final Conversor conversor = new Conversor();
    private final Scanner entrada = new Scanner(System.in);

    public void execute() {
        while (true) {
            System.out.println("\n*** Screen Sound Músicas ***");
            int num = LeitorInteiro.ler("""                    
                    1 - Cadastrar artistas
                    2 - Cadastrar músicas
                    3 - Listar músicas
                    4 - Buscar músicas por artistas
                    5 - Pesquisar dados sobre um artista
                    6 - Cadastrar musicas em lote
                    7 - Listar Artistas
                    0 - Sair
                    """, entrada, 0, 7);

            switch (num) {
                case 1 -> cadastrarArtista();
                case 2 -> cadastrarMusicas();
                case 3 -> listarMusicas();
                case 4 -> buscaPorArtista();
                case 5 -> pesquisaArtista();
                case 6 -> cadastroRapidoMusica();
                case 7 -> listarArtistas();
                case 0 -> {
                    System.out.println("Encerrando aplicação...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }



    private Optional<Artista> buscarOuSelecionarArtista() {
        System.out.println("Informe o nome do artista:");
        var nome = entrada.nextLine();

        if (nome == null || nome.isBlank()) {
            System.out.println("Nome inválido.");
            return Optional.empty();
        }

        List<Artista> encontrados = artistaRepository.findByNameContainingIgnoreCase(nome);

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum artista encontrado com o termo: '" + nome + "'");
            return Optional.empty();
        }

        if (encontrados.size() == 1) {
            return Optional.of(encontrados.get(0));
        }

        System.out.println("Foram encontrados múltiplos artistas. Selecione um:");
        for (int i = 0; i < encontrados.size(); i++) {
            System.out.println((i + 1) + " - " + encontrados.get(i).getName());
        }

        int opcao = LeitorInteiro.ler("Escolha o número:", entrada, 1, encontrados.size());
        return Optional.of(encontrados.get(opcao - 1));
    }

    private void cadastrarArtista() {
        System.out.println("Digite o nome do artista para buscar na Deezer:");
        var nome = entrada.nextLine();

        if (nome == null || nome.isBlank()) {
            System.out.println("Nome inválido.");
            return;
        }

        var endereco = "https://api.deezer.com/search/artist?q=" + java.net.URLEncoder.encode(nome, java.nio.charset.StandardCharsets.UTF_8);
        var json = consumoApi.obterDados(endereco);
        var resposta = conversor.obterDados(json, com.nadson.ScreenSoundMusicas.domain.dto.DTORespostaDeezer.class);

        if (resposta.data() == null || resposta.data().isEmpty()) {
            System.out.println("Nenhum artista encontrado na Deezer com esse nome.");
            return;
        }

        var dadosArtista = resposta.data().stream()
                .max((a1, a2) -> Integer.compare(
                        a1.totalFans() != null ? a1.totalFans() : 0,
                        a2.totalFans() != null ? a2.totalFans() : 0
                ))
                .orElse(resposta.data().get(0));

        var artistaExistente = artistaRepository.findByNameContainingIgnoreCase(dadosArtista.name());
        if (!artistaExistente.isEmpty()) {
            System.out.println("O artista oficial da Deezer já está no seu banco: " + artistaExistente.get(0).getName());
            return;
        }

        System.out.println("Artista encontrado: " + dadosArtista.name());
        int tipoOpcao = LeitorInteiro.ler("Informe o tipo do artista (1-SOLO, 2-DUPLA, 3-GRUPO):", entrada, 1, 3);

        var tipo = switch (tipoOpcao) {
            case 1 -> TipoArtista.SOLO;
            case 2 -> TipoArtista.DUPLA;
            case 3 -> TipoArtista.GRUPO;
            default -> TipoArtista.SOLO;
        };

        var artista = new Artista(dadosArtista.name(), tipo, dadosArtista.pictureBig(), null);
        artistaRepository.save(artista);
        System.out.println("Artista cadastrado com sucesso com a foto oficial da Deezer!");
    }

    private void listarMusicas() {
        List<Musica> musicas = musicaRepository.findAll();
        if (musicas.isEmpty()) {
            System.out.println("Nenhuma música cadastrada no banco de dados.");
            return;
        }

        System.out.println("\n--- Lista Geral de Músicas ---");
        musicas.forEach(System.out::println);
    }

    private void buscaPorArtista() {
        Optional<Artista> artistaOpt = buscarOuSelecionarArtista();
        if (artistaOpt.isEmpty()) {
            return;
        }

        Artista artista = artistaOpt.get();
        List<Musica> musicas = musicaRepository.findByArtistaNameContainingIgnoreCase(artista.getName());

        if (musicas.isEmpty()) {
            System.out.println("Nenhuma música encontrada para o artista: " + artista.getName());
            return;
        }

        System.out.println("\n--- Músicas de " + artista.getName() + " ---");
        musicas.forEach(System.out::println);
    }

    private void pesquisaArtista() {
        System.out.println("Pesquisar dados sobre qual artista?");
        var nome = entrada.nextLine();
        if (nome.isBlank()) return;

        var endereco = "https://api.deezer.com/search/artist?q=" + nome.replace(" ", "%20");

        var json = consumoApi.obterDados(endereco);
        var resposta = conversor.obterDados(json, com.nadson.ScreenSoundMusicas.domain.dto.DTORespostaDeezer.class);

        if (resposta.data() != null && !resposta.data().isEmpty()) {

            var artistaEncontrado = resposta.data().stream()
                    .max((a1, a2) -> Integer.compare(
                            a1.totalFans() != null ? a1.totalFans() : 0,
                            a2.totalFans() != null ? a2.totalFans() : 0
                    ))
                    .orElse(resposta.data().get(0));

            System.out.println("\n--- Dados do Artista (Deezer) ---");
            System.out.println("Nome: " + artistaEncontrado.name());
            System.out.println("Total de Fãs: " + artistaEncontrado.totalFans());
            System.out.println("Total de Álbuns: " + artistaEncontrado.totalAlbuns());
            System.out.println("Imagem: " + artistaEncontrado.pictureBig());
            System.out.println("Link Deezer: " + artistaEncontrado.link());
            System.out.println("---------------------------------\n");
            System.out.println("Buscando resumo biográfico na Wikipédia...");
            String biografia = gerarBiografiaWikipedia(artistaEncontrado.name());

            System.out.println("\n--- Biografia (Wikipédia) ---");
            System.out.println(biografia);
            System.out.println("-----------------------------\n");
        } else {
            System.out.println("Artista não encontrado na Deezer.");
        }

    }

    private void cadastrarMusicas() {
        System.out.println("Digite o título da música:");
        var nomeMusica = entrada.nextLine();
        System.out.println("De qual artista é essa música?");
        var nomeArtista = entrada.nextLine();

        processarBuscaMusica(nomeMusica, nomeArtista);
    }

    private void cadastroRapidoMusica() {
        System.out.println("Digite 'Música, Artista' (uma por linha). Digite FIM para encerrar e iniciar a busca.");
        System.out.println("Exemplo: Circo dos horrores, 7 minutoz");

        List<String> lote = new ArrayList<>();
        while (true) {
            var linha = entrada.nextLine();
            if (linha.equalsIgnoreCase("fim")) break;
            if (!linha.isBlank() && linha.contains(",")) lote.add(linha);
        }

        for (String item : lote) {
            String[] partes = item.split(",");
            System.out.println("\n==========================================");
            System.out.println(">>> Processando: " + partes[0].trim() + " - " + partes[1].trim());
            processarBuscaMusica(partes[0].trim(), partes[1].trim());
        }
    }
    private void listarArtistas() {
        System.out.println("\n--- Artistas Cadastrados ---");
        var artistas = artistaRepository.findAll();
        if (artistas.isEmpty()) {
            System.out.println("Nenhum artista cadastrado.");
        } else {
            artistas.forEach(System.out::println);
        }
    }
    private void processarBuscaMusica(String nomeMusica, String nomeArtista) {
        String queryAberta = nomeMusica + " " + nomeArtista;
        var endereco = "https://api.deezer.com/search/track?q=" + java.net.URLEncoder.encode(queryAberta, java.nio.charset.StandardCharsets.UTF_8);

        var json = consumoApi.obterDados(endereco);
        var resposta = conversor.obterDados(json, com.nadson.ScreenSoundMusicas.domain.dto.DTORespostaMusicaDeezer.class);

        if (resposta.data() == null || resposta.data().isEmpty()) {
            System.out.println("Nenhum resultado encontrado na Deezer para essa música/artista.");
            return;
        }

        var opcoes = resposta.data().stream()
                .filter(m -> m.artist() != null && m.artist().name().toLowerCase().contains(nomeArtista.toLowerCase()))
                .limit(5).toList();

        if (opcoes.isEmpty()) {
            opcoes = resposta.data().stream().limit(5).toList();
        }

        System.out.println("\n--- Opções Encontradas na Deezer para '" + nomeMusica + "' ---");
        for (int i = 0; i < opcoes.size(); i++) {
            var op = opcoes.get(i);
            String nomeAlbum = op.album() != null ? op.album().title() : "Single";
            System.out.printf("%d - Música: '%s' | Álbum: '%s' | Artista: %s%n",
                    (i + 1), op.title(), nomeAlbum, op.artist().name());
        }

        int escolha = LeitorInteiro.ler("Digite o número da opção (ou 0 para pular): ", entrada, 0, opcoes.size());
        if (escolha == 0) {
            System.out.println("Busca pulada.");
            return;
        }

        var dadosMusica = opcoes.get(escolha - 1);
        var dadosArtistaDeezer = dadosMusica.artist();
        var artistasNoBanco = artistaRepository.findByNameContainingIgnoreCase(dadosArtistaDeezer.name());
        Artista artista;

        if (artistasNoBanco.isEmpty()) {
            System.out.println("\nO artista '" + dadosArtistaDeezer.name() + "' não está no banco. Vamos cadastrá-lo!");
            int tipoOpcao = LeitorInteiro.ler("Informe o tipo (1-SOLO, 2-DUPLA, 3-GRUPO): ", entrada, 1, 3);
            var tipo = switch (tipoOpcao) {
                case 1 -> TipoArtista.SOLO;
                case 2 -> TipoArtista.DUPLA;
                case 3 -> TipoArtista.GRUPO;
                default -> TipoArtista.SOLO;
            };
            artista = new Artista(dadosArtistaDeezer.name(), tipo, dadosArtistaDeezer.pictureBig(), null);
        } else {
            artista = artistasNoBanco.get(0);
        }

        String nomeAlbumFinal = dadosMusica.album() != null ? dadosMusica.album().title() : "Single";
        var musica = new Musica(dadosMusica.title(), dadosMusica.duration(), nomeAlbumFinal, dadosMusica.link(), artista);
        artista.adicionarMusica(musica);
        artistaRepository.save(artista);

        System.out.println("Música salva com sucesso: " + musica.getTitulo());
    }
    private String gerarBiografiaWikipedia(String nomeArtista) {
        String nomeFormatado = java.net.URLEncoder.encode(nomeArtista.replace(" ", "_"), java.nio.charset.StandardCharsets.UTF_8);
        String endereco = "https://pt.wikipedia.org/api/rest_v1/page/summary/" + nomeFormatado;

        try {
            String json = consumoApi.obterDados(endereco);

            var mapper = new ObjectMapper(); // Troque para tools.jackson se estiver no Jackson 3
            var rootNode = mapper.readTree(json);

            if (rootNode.has("extract")) {
                return rootNode.path("extract").asText();
            } else {
                return "Biografia não encontrada na Wikipédia em português.";
            }
        } catch (Exception e) {
            return "Não foi possível localizar a página oficial deste artista na Wikipédia em português.";
        }
    }
}