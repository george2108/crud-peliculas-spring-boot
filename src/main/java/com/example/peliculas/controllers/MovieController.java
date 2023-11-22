package com.example.peliculas.controllers;

import com.example.peliculas.entities.Movie;
import com.example.peliculas.services.IActorService;
import com.example.peliculas.services.IGenderService;
import com.example.peliculas.services.IMovieService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private final IMovieService movieService;
    private final IGenderService genderService;
    private final IActorService actorService;

    public MovieController(
            IMovieService movieService,
            IGenderService genderService,
            IActorService actorService
    ){
        this.movieService = movieService;
        this.genderService = genderService;
        this.actorService = actorService;
    }

    @GetMapping
    public String saveView(Model model){
        Movie movie = new Movie();
        model.addAttribute("title", "New movie");
        model.addAttribute("movie", movie);
        model.addAttribute("genders", genderService.findAll());
        model.addAttribute("actors", actorService.findAll());
        return "movie";
    }

    @PostMapping("/save")
    public String save(
            @Valid Movie movie,
            BindingResult br,
            // id de cada actor separado por coma -> (1,2,3)
            @ModelAttribute(name = "ids") String ids
    ){
        if(br.hasErrors()){
            return "movie";
        }

        List<Long> idsActors = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        movie.setActors(actorService.findAllByIds(idsActors));
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
        model.addAttribute("actors", actorService.findAll());
        return "movie";
    }

}
