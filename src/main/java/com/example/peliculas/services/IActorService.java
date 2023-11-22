package com.example.peliculas.services;

import com.example.peliculas.entities.Actor;

import java.util.List;

public interface IActorService {
     List<Actor> findAll();

     List<Actor> findAllByIds(List<Long> id);

     Actor findById(Long id);

     Actor save(String name, String urlImage);
}
