package com.example.peliculas.controllers;

import com.example.peliculas.entities.Actor;
import com.example.peliculas.services.IActorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/actors")
public class ActorController {
    private final IActorService actorService;

    public ActorController(IActorService actorService){
        this.actorService = actorService;
    }

    @PostMapping
    public Actor save(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "urlImage") String urlImage
    ){
        return actorService.save(name, urlImage);
    }
}
