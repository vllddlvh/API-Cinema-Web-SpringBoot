package com.cinemaweb.API.Cinema.Web.service;

import com.cinemaweb.API.Cinema.Web.entity.Film;
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

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }
}
