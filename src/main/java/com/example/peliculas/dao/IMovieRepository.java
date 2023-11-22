package com.example.peliculas.dao;

import com.example.peliculas.entities.Movie;
import org.springframework.data.repository.CrudRepository;

public interface IMovieRepository extends CrudRepository<Movie, Long> {
}
