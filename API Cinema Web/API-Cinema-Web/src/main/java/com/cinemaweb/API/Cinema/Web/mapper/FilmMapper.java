package com.cinemaweb.API.Cinema.Web.mapper;

import com.cinemaweb.API.Cinema.Web.dto.request.FilmCreateRequest;
import com.cinemaweb.API.Cinema.Web.dto.request.FilmUpdateRequest;
import com.cinemaweb.API.Cinema.Web.dto.response.FilmResponse;
import com.cinemaweb.API.Cinema.Web.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FilmMapper {
    FilmResponse toFilmResponse(Film film);

    Film toFilm(FilmCreateRequest filmCreateRequest);

    void updateFilm(@MappingTarget Film film, FilmUpdateRequest filmUpdateRequest);
}
