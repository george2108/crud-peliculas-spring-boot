package com.example.peliculas.controllers;

import com.example.peliculas.entities.Movie;
import com.example.peliculas.services.IGenderService;
import com.example.peliculas.services.IMovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final IMovieService movieService;
    private final IGenderService genderService;

    public MovieController(IMovieService movieService, IGenderService genderService){
        this.movieService = movieService;
        this.genderService = genderService;
    }

    @GetMapping
    public String saveView(Model model){
        Movie movie = new Movie();
        model.addAttribute("title", "New movie");
        model.addAttribute("movie", movie);
        model.addAttribute("genders", genderService.findAll());
        return "movie";
    }

    @PostMapping("/save")
    public String save(Movie movie){
        movieService.save(movie);
        return "redirect:home";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model){
        Movie movie = new Movie();
        model.addAttribute("title", "Edit movie");
        model.addAttribute("movie", movie);
        model.addAttribute("genders", genderService.findAll());
        return "movie";
    }

}
