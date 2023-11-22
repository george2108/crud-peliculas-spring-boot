package com.example.peliculas.services;

import com.example.peliculas.dao.IActorRepository;
import com.example.peliculas.entities.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements  IActorService{
    @Autowired
    IActorRepository actorRepository;

    @Override
    public List<Actor> findAll() {
        return (List<Actor>) actorRepository.findAll();
    }

    @Override
    public List<Actor> findAllByIds(List<Long> id) {
        return (List<Actor>) actorRepository.findAllById(id);
    }

    @Override
    public Actor findById(Long id) {
        return actorRepository.findById(id).orElse(null);
    }

    @Override
    public Actor save(String name, String urlImage) {
        Actor actor = new Actor();
        actor.setName(name);
        actor.setUrlImage(urlImage);
        return actorRepository.save(actor);
    }
}
