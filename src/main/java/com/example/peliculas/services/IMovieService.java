package com.example.peliculas.services;

import com.example.peliculas.entities.Movie;

import java.util.List;

public interface IMovieService {
    public void save(Movie movie);

    public List<Movie> findAll();

    public Movie findById(Long id);

    public void delete(Long id);
}
