package com.nadson.ScreenSoundMusicas.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DTOMusicaDeezer(
        Long id,
        String title,
        Integer duration,
        String link,
        Integer rank,
        DTOArtistaDeezer artist,
        DTOAlbumDeezer album
) {}