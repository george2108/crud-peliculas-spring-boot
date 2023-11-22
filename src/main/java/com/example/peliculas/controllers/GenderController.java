package com.example.peliculas.controllers;

import com.example.peliculas.dao.IGenderRepository;
import com.example.peliculas.entities.Gender;
import com.example.peliculas.services.IGenderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/genders")
public class GenderController {
    private final IGenderService genderService;

    public GenderController(IGenderService genderService){
        this.genderService = genderService;
    }

    @PostMapping
    public Long save(@RequestParam(value = "name", required = false) String name){
        Gender gender = new Gender();
        gender.setName(name);
        this.genderService.save(gender);
        return gender.getId();
    }

    @GetMapping("/{id}")
    public Gender searchById(@PathVariable(name = "id") Long id){
        return genderService.findById(id);
    }
}
