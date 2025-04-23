package com.cinemaweb.API.Cinema.Web.controller;

import com.cinemaweb.API.Cinema.Web.dto.request.FilmRequest;
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
@RequestMapping("/films")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmController {
    @Autowired
    FilmService filmService;

    @GetMapping
    public List<FilmResponse> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/{filmid}")
    public FilmResponse getFilm(@PathVariable String filmid) {
        return filmService.getFilm(filmid);
    }

    @PostMapping
    public void createFilm(@RequestBody @Valid FilmRequest filmCreateRequest) {
        filmService.createFilm(filmCreateRequest);
    }

    @PutMapping("{filmid}")
    public FilmResponse updateFilm(@PathVariable String filmid, @RequestBody FilmRequest filmUpdateRequest) {
        return filmService.updateFilm(filmid, filmUpdateRequest);
    }

    @DeleteMapping("{filmid}")
    public String deleteFilm(@PathVariable String filmid) {
        filmService.deleteFilm(filmid);
        return "Film with id" + filmid + " has been deleted";
    }
}
