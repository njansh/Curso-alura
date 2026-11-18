package com.nadson.screenmacth_frases.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FrasesRepository extends JpaRepository<Frases, Long> {
    @Query(value = "SELECT * FROM frases ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Frases> buscarFrase();
}
