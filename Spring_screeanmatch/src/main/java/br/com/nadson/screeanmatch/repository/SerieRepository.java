package br.com.nadson.screeanmatch.repository;

import br.com.nadson.screeanmatch.enums.Categoria;
import br.com.nadson.screeanmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    Optional<Serie> findByTituloIgnoreCase(String titulo);

    // List<Serie> findByGenero(Categoria genero);
    @Query("SELECT s FROM Serie s WHERE s.genero = :genero")
    List<Serie> seriePorGenero(@Param("genero") Categoria genero);

    // List<Serie> findBySinopseContainingIgnoreCase(String trecho);
    @Query("SELECT s FROM Serie s WHERE LOWER(s.sinopse) LIKE LOWER(CONCAT('%', :trecho, '%'))")
    List<Serie> buscarSinopse(@Param("trecho") String trecho);

    // List<Serie> findByAtoresContainingIgnoreCase(String trecho);
    @Query("SELECT s FROM Serie s WHERE LOWER(s.atores) LIKE LOWER(CONCAT('%', :trecho, '%'))")
    List<Serie> seriesPorAtor(@Param("trecho") String trecho);

    // List<Serie> findTop5ByOrderByAvaliacaoDesc();
    @Query("SELECT s FROM Serie s ORDER BY s.avaliacao DESC LIMIT 5")
    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    // List<Serie> findByTotalTemporadasLessThanEqualOrderByTotalTemporadasAsc(int num);
    @Query("SELECT s FROM Serie s WHERE s.totalTemporadas <= :num ORDER BY s.totalTemporadas ASC")
    List<Serie> seriesPorTemporadaMaxima(@Param("num") int num);

    // List<Serie> findByAvaliacaoGreaterThanEqualOrderByAvaliacaoDesc(double notaMinima);
    @Query("SELECT s FROM Serie s WHERE s.avaliacao >= :notaMinima ORDER BY s.avaliacao DESC")
    List<Serie> findByAvaliacaoGreaterThanEqual(@Param("notaMinima") double notaMinima);
}