package com.cinemaweb.API.Cinema.Web.service;

import com.cinemaweb.API.Cinema.Web.dto.request.FilmRequest;
import com.cinemaweb.API.Cinema.Web.dto.response.FilmResponse;
import com.cinemaweb.API.Cinema.Web.entity.Film;
import com.cinemaweb.API.Cinema.Web.mapper.FilmMapper;
import com.cinemaweb.API.Cinema.Web.repository.FilmRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmService {
    @Autowired
    FilmRepository filmRepository;

    @Autowired
    FilmMapper filmMapper;

    public List<FilmResponse> getAllFilms() {
        return filmMapper.toFilmResponseList(filmRepository.findAll());
    }

    public FilmResponse getFilm(String filmId) {
        return filmMapper.toFilmResponse(filmRepository.findById(filmId).orElseThrow(()
        -> new RuntimeException("User not found")));
    }

    public void createFilm(FilmRequest filmCreateRequest) {
        filmRepository.save(filmMapper.toFilm(filmCreateRequest));
    }

    public FilmResponse updateFilm(String filmId, FilmRequest filmUpdateRequest) {
        Film film = filmRepository.findById(filmId).orElseThrow(()
                -> new RuntimeException("User not found"));

        filmMapper.updateFilm(film, filmUpdateRequest);
        return filmMapper.toFilmResponse(filmRepository.save(film));
    }

    public void deleteFilm(String filmId) {
        filmRepository.deleteById(filmId);
    }
}
