package br.com.nadson.screeanmatch.service;

import br.com.nadson.screeanmatch.controller.EpisodioDTO;
import br.com.nadson.screeanmatch.controller.SerieDTO;
import br.com.nadson.screeanmatch.enums.Categoria;
import br.com.nadson.screeanmatch.model.Episodio;
import br.com.nadson.screeanmatch.model.Serie;
import br.com.nadson.screeanmatch.repository.EpisodioRepository;
import br.com.nadson.screeanmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {
    @Autowired
    SerieRepository serieRepository;
    @Autowired
    EpisodioRepository episodioRepository;

    private SerieDTO toSerieDTO(Serie serie) {
        return new SerieDTO(
                serie.getId(),
                serie.getTitulo(),
                serie.getTotalTemporadas(),
                serie.getAvaliacao(),
                serie.getGenero(),
                serie.getSinopse(),
                serie.getPoster(),
                serie.getAtores()
        );
    }

    private EpisodioDTO toEpisodioDTO(Episodio episodio) {
        return new EpisodioDTO(
                episodio.getId(),
                episodio.getNome(),
                episodio.getTemporada(),
                episodio.getNumero(),
                episodio.getAvaliacao(),
                episodio.getDataLancamento()
        );
    }

    private List<SerieDTO> converterDados(List<Serie> series) {
        return series.stream().map(this::toSerieDTO).collect(Collectors.toList());
    }

    private List<EpisodioDTO> converterEpisodios(List<Episodio> episodios) {
        return episodios.stream().map(this::toEpisodioDTO).collect(Collectors.toList());
    }

    public List<SerieDTO> encotrarTodasAsSeries() {
        return converterDados(serieRepository.findAll());
    }

    public List<SerieDTO> top5Series() {
        return converterDados(serieRepository.top5Series());
    }

    public List<SerieDTO> findTop5ByOrderByEpisodiosDataLancamentoDesc() {
        return converterDados(serieRepository.findTop5ByOrderByEpisodiosDataLancamentoDesc());
    }

    public SerieDTO buscaPorID(long id) {
        return serieRepository.findById(id)
                .map(this::toSerieDTO)
                .orElse(null);
    }

    public List<EpisodioDTO> buscarTodasTemporadas(long id) {
        return converterEpisodios(episodioRepository.findBySerieId(id));
    }

    public List<EpisodioDTO> buscarEpisodiosPorTemporada(long id, int numeroTemporada) {
        return converterEpisodios(episodioRepository.seriesPorTemporadas(id, numeroTemporada));
    }

    public List<SerieDTO> obterSeriesPorCategoria(String nomeGenero) {
        Categoria categoria = Categoria.fromString(nomeGenero);
        return converterDados(serieRepository.seriePorGenero(categoria));
    }

    public List<EpisodioDTO> buscarTop5(Long id) {
        return converterEpisodios(episodioRepository.Top5Episodios(id));
    }
}

