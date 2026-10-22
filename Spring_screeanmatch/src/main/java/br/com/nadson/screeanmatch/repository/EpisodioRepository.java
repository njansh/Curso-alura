package br.com.nadson.screeanmatch.repository;

import br.com.nadson.screeanmatch.model.Episodio;
import br.com.nadson.screeanmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodioRepository extends JpaRepository<Episodio, Long> {

    List<Episodio> findBySerie(Serie serie);

    List<Episodio> findBySerieAndTemporada(Serie serie, Integer temporada);

    List<Episodio> findBySerieAndNomeContainingIgnoreCase(Serie serie, String trechoNome);

    List<Episodio> findTop5BySerieOrderByAvaliacaoDesc(Serie serie);

    @Query("SELECT e FROM Episodio e WHERE e.serie = :serie AND YEAR(e.dataLancamento) >= :anoLancamento")
    List<Episodio> findEpisodesBySeriesAndYear(@Param("serie") Serie serie, @Param("anoLancamento") int anoLancamento);

    List<Episodio> findTop5ByOrderByAvaliacaoDesc();
}