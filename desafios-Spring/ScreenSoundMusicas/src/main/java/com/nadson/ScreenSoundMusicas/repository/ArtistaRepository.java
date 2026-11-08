package com.nadson.ScreenSoundMusicas.repository;

import com.nadson.ScreenSoundMusicas.domain.Artista;
import com.nadson.ScreenSoundMusicas.enums.TipoArtista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    List<Artista> findByNameContainingIgnoreCase(String nome);

    List<Artista> findByTipo(TipoArtista tipo);



}
