package com.nadson.ScreenSoundMusicas.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DTOAlbumDeezer(
        Long id,
        String title
) {}