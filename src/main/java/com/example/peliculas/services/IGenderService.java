package com.example.peliculas.services;

import com.example.peliculas.entities.Gender;

import java.util.List;

public interface IGenderService {
    public void save(Gender gender);

    public Gender findById(Long id);

    public void delete(Long id);

    public List<Gender> findAll();
}
