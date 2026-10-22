package br.com.nadson.screeanmatch.repository;

import br.com.nadson.screeanmatch.enums.Categoria;
import br.com.nadson.screeanmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    // Busca exata pelo título ignorando maiúsculas/minúsculas (use no buscarSeriePorNome para evitar NonUniqueResultException com termos curtos como "er")
    Optional<Serie> findByTituloIgnoreCase(String titulo);

    // Busca pelo primeiro resultado que contenha o trecho digitado (ótima para a pesquisa interativa do usuário)
    Optional<Serie> findFirstByTituloContainingIgnoreCase(String trechoTitulo);

    // Busca por gênero/categoria
    List<Serie> findByGenero(Categoria genero);

    // Busca séries com aviso de cota de tradução na sinopse (para a rotina de correção)
    List<Serie> findBySinopseContainingIgnoreCase(String trecho);
}