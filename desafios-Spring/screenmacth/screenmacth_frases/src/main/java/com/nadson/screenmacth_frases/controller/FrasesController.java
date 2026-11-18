package com.nadson.screenmacth_frases.controller;

import com.nadson.screenmacth_frases.domain.FrasesService;
import com.nadson.screenmacth_frases.dto.FrasesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("/series")
public class FrasesController {

    @Autowired
    private FrasesService frasesService;

    @GetMapping("/frases")
    public FrasesDTO buscarFraseAleatoria() {
        return frasesService.buscaAleatoria();
    }
}
