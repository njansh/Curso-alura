package br.com.nadson.screeanmatch.repository;

import br.com.nadson.screeanmatch.model.Episodio;
import br.com.nadson.screeanmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodioRepository extends JpaRepository<Episodio, Long> {

    List<Episodio> findBySerie(Serie serie);

    // List<Episodio> findBySerieAndTemporada(Serie serie, Integer temporada);
    @Query("SELECT e FROM Episodio e WHERE e.serie = :serie AND e.temporada = :temporada")
    List<Episodio> seriesPorTemporadas(@Param("serie") Serie serie, @Param("temporada") Integer temporada);

    // List<Episodio> findBySerieAndNomeContainingIgnoreCase(Serie serie, String trechoNome);
    @Query("SELECT e FROM Episodio e WHERE e.serie = :serie AND e.nome ILIKE %:trechoNome%")
    List<Episodio> episodiosPorTrecho(@Param("serie") Serie serie, @Param("trechoNome") String trechoNome);



    @Query("SELECT e FROM Episodio e WHERE e.serie = :serie AND YEAR(e.dataLancamento) >= :anoLancamento")
    List<Episodio> episodiosPorAno(@Param("serie") Serie serie, @Param("anoLancamento") int anoLancamento);

    // List<Episodio> findTop5BySerieOrderByAvaliacaoDesc(Serie serie);
    @Query("SELECT e FROM Episodio e WHERE e.serie = :serie ORDER BY e.avaliacao DESC LIMIT 5")
    List<Episodio> Top5Episodios(@Param("serie") Serie serie);
    }