package com.cinemaweb.API.Cinema.Web.controller;

import com.cinemaweb.API.Cinema.Web.dto.request.FilmCreateRequest;
import com.cinemaweb.API.Cinema.Web.dto.request.FilmUpdateRequest;
import com.cinemaweb.API.Cinema.Web.dto.response.FilmResponse;
import com.cinemaweb.API.Cinema.Web.entity.Film;
import com.cinemaweb.API.Cinema.Web.service.FilmService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmController {
    @Autowired
    FilmService filmService;

    @GetMapping("/films")
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/{filmid}")
    public FilmResponse getFilm(@PathVariable String filmid) {
        return filmService.getFilm(filmid);
    }

    @PostMapping
    public void createFilm(@RequestBody @Valid FilmCreateRequest filmCreateRequest) {
        filmService.createFilm(filmCreateRequest);
    }

    @PutMapping("{filmid}")
    public FilmResponse updateFilm(@PathVariable String filmid, @RequestBody FilmUpdateRequest filmUpdateRequest) {
        return filmService.updateFilm(filmid, filmUpdateRequest);
    }

    @DeleteMapping("{filmid}")
    public List<Film> deleteFilm(@PathVariable String filmid) {
        filmService.deleteFilm(filmid);
        return filmService.getAllFilms();
    }
}
