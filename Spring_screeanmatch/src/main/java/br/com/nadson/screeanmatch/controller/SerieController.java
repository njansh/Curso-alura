package br.com.nadson.screeanmatch.controller;

import br.com.nadson.screeanmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    SerieService serieService;
    @GetMapping
    public Iterable<SerieDTO> findAll() {
        return serieService.encotrarTodasAsSeries();
    }
    @GetMapping("/top5")
    public Iterable<SerieDTO> findTop5Series() {
        return serieService.top5Series();
    }
    @GetMapping("/lancamentos")
    public  Iterable<SerieDTO> findAllLancamentos() {
        return serieService.findTop5ByOrderByEpisodiosDataLancamentoDesc();
    }
    @GetMapping("/{id}")
    public SerieDTO findById(@PathVariable Long id) {
        return serieService.buscaPorID(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> buscarTodasTemporadas(@PathVariable Long id) {
        return serieService.buscarTodasTemporadas(id);
    }

    @GetMapping("/{id}/temporadas/{numero}")
    public List<EpisodioDTO> buscarEpisodiosPorTemporada(@PathVariable Long id, @PathVariable int numero) {
        return serieService.buscarEpisodiosPorTemporada(id, numero);
    }
    @GetMapping("/categoria/{nomeGenero}")
    public List<SerieDTO> obterSeriesPorCategoria(@PathVariable String nomeGenero) {
        return serieService.obterSeriesPorCategoria(nomeGenero);
    }
    @GetMapping("{id}/temporadas/top5")
    public List<EpisodioDTO> buscarTop5(@PathVariable Long id) {
        return serieService.buscarTop5(id);
    }


}
