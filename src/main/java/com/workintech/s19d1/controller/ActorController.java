package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.ActorRequest;
import com.workintech.s19d1.dto.ActorResponse;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.ActorService;
import com.workintech.s19d1.util.Converter;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/actor")
public class ActorController {
    private ActorService actorService;
    @GetMapping
    public List<ActorResponse> getAll() {
        List<Actor> actors= actorService.findAll();
        return Converter.actorResponseConvert(actors) ;
    }
    @GetMapping("/{id}")
    public ActorResponse getById(@PathVariable("id") Long id) {
        Actor actor = actorService.findById(id);
        return Converter.actorResponseConvert(actor) ;
    }

    @Transactional
    @PutMapping("/{id}")
    public ActorResponse update(@PathVariable("id") Long id, @RequestBody Actor actor) {
        Actor foundActor = actorService.findById(id);
        actor.setMovies(foundActor.getMovies());
        actor.setId(id);
        actorService.save(actor);
        return Converter.actorResponseConvert(actor);

    }

    @Transactional
    @PostMapping
    public ActorResponse save(@Validated @RequestBody ActorRequest actorRequest) {
        Actor actor = actorRequest.getActor();
        List<Movie> movies = actorRequest.getMovies();
        for(Movie movie: movies) {
            actor.addMovie(movie);
        }
        Actor savedActor = actorService.save(actor);
        return Converter.actorCreateResponseConvert(savedActor);
    }
    @Transactional
    @DeleteMapping("/{id}")
    public ActorResponse delete (@PathVariable("id") Long id) {
        Actor foundActor = actorService.findById(id);
        actorService.delete(foundActor);
        return Converter.actorResponseConvert(foundActor);
    }
}
