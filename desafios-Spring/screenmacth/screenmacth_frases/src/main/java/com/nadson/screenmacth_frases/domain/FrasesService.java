package com.nadson.screenmacth_frases.domain;

import com.nadson.screenmacth_frases.dto.FrasesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrasesService {
    @Autowired
   private  FrasesRepository frasesRepository;

    public FrasesDTO buscaAleatoria(){
        Frases frases = frasesRepository.buscarFrase().orElse(null);
        if (frases == null) {
            return null;
        }
        return new FrasesDTO(
                frases.getId(),
                frases.getTitulo(),
                frases.getFrase(),
                frases.getPersonagem(),
                frases.getPoster()
        );
    }
}
