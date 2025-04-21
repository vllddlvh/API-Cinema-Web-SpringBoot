package com.cinemaweb.API.Cinema.Web.mapper;

import com.cinemaweb.API.Cinema.Web.dto.request.FilmRequest;
import com.cinemaweb.API.Cinema.Web.dto.response.FilmResponse;
import com.cinemaweb.API.Cinema.Web.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FilmMapper {
    FilmResponse toFilmResponse(Film film);

    Film toFilm(FilmRequest filmCreateRequest);

    void updateFilm(@MappingTarget Film film, FilmRequest filmUpdateRequest);
}
