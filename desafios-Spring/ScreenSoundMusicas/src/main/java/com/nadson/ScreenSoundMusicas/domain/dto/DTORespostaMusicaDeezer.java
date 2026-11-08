package com.nadson.ScreenSoundMusicas.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DTORespostaMusicaDeezer(
        List<DTOMusicaDeezer> data,
        Integer total
) {}