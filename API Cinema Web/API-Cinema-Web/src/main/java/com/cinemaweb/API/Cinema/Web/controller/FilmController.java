package com.cinemaweb.API.Cinema.Web.controller;

import com.cinemaweb.API.Cinema.Web.entity.Film;
import com.cinemaweb.API.Cinema.Web.service.FilmService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinema")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmController {
    @Autowired
    FilmService filmService;

    @GetMapping("/films")
    public List<Film> GetAllFilms() {
        return filmService.getAllFilms();
    }
}
