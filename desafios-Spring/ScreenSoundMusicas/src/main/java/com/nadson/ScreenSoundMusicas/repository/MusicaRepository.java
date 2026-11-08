package com.nadson.ScreenSoundMusicas.repository;

import com.nadson.ScreenSoundMusicas.domain.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MusicaRepository extends JpaRepository<Musica,Long> {

    Optional<Musica> findByTituloContainingIgnoreCase(String titulo);

    List<Musica> findByArtistaNameContainingIgnoreCase(String name);
}
