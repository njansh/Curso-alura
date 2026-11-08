package com.nadson.ScreenSoundMusicas.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DTORespostaDeezer(
        List<DTOArtistaDeezer> data,
        Integer total
) {}