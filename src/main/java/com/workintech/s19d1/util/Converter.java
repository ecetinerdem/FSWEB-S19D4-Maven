package com.workintech.s19d1.util;

import com.workintech.s19d1.dto.ActorResponse;
import com.workintech.s19d1.dto.MovieResponse;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static List<ActorResponse> actorResponseConvert(List<Actor> actors) {
        List<ActorResponse> actorResponses = new ArrayList<>();
        for (Actor actor: actors) {
            actorResponses.add(new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(),actor.getBirthDate(),actor.getMovies()));
        }
        return actorResponses;
    }

    public static ActorResponse actorResponseConvert(Actor actor) {
        return new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getBirthDate(),actor.getMovies());
    }

    public static ActorResponse actorCreateResponseConvert(Actor savedActor) {
        return new ActorResponse(savedActor.getId(), savedActor.getFirstName(), savedActor.getLastName(), savedActor.getBirthDate(),savedActor.getMovies());
    }

    public static List<MovieResponse> movieResponseConvert(List<Movie> movies) {
        List<MovieResponse>movieResponses = new ArrayList<>();
        for (Movie movie: movies) {
            movieResponses.add(new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(), movie.getRating(), movie.getReleaseDate(), movie.getActors()));
        }
        return movieResponses;
    }
    public static MovieResponse movieResponse(Movie movie) {
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(), movie.getRating(), movie.getReleaseDate(), movie.getActors());
    }

    public static MovieResponse movieCreateResponse(Movie savedMovie) {
        return new MovieResponse(savedMovie.getId(), savedMovie.getName(), savedMovie.getDirectorName(), savedMovie.getRating(), savedMovie.getReleaseDate(),savedMovie.getActors());
    }

}
