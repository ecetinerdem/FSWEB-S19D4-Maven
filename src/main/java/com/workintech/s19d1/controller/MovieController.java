package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.MovieRequest;
import com.workintech.s19d1.dto.MovieResponse;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import com.workintech.s19d1.util.Converter;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public List<MovieResponse> getAll() {
        List<Movie> movies = movieService.findAll();
        return Converter.movieResponseConvert(movies);
    }

    @GetMapping("/{id}")
    public MovieResponse getById(@PathVariable("id") Long id) {
        Movie foundMovie = movieService.findById(id);
        return  Converter.movieResponse(foundMovie);
    }

    @Transactional
    @PutMapping("/{id}")
    public MovieResponse update(@PathVariable("id") Long id, @RequestBody Movie movie) {
        Movie foundMovie = movieService.findById(id);
        movie.setActors(foundMovie.getActors());
        movie.setId(id);
        movieService.save(movie);
        return Converter.movieResponse(movie);

    }

    @Transactional
    @PostMapping
    public MovieResponse save (@Validated @RequestBody MovieRequest movieRequest) {
        Movie movie = movieRequest.getMovie();
        List<Actor> actors = movieRequest.getActors();
        for(Actor actor: actors) {
            movie.addActor(actor);
        }
        Movie savedMovie = movieService.save(movie);
        return Converter.movieCreateResponse(savedMovie);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public MovieResponse delete(@PathVariable("id") Long id) {
        Movie foundMovie = movieService.findById(id);
        movieService.delete(foundMovie);
        return Converter.movieResponse(foundMovie);
    }
}
