package com.nadson.ScreenSoundMusicas.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DTOArtistaDeezer(
        Long id,
        String name,
        String link,
        @JsonAlias("picture_big") String pictureBig,
        @JsonAlias("nb_album") Integer totalAlbuns,
        @JsonAlias("nb_fan") Integer totalFans
) {}