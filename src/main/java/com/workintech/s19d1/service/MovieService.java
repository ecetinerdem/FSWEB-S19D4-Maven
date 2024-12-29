package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(Long id);
    Movie update(Long id, Movie movie);
    Movie save(Movie movie);
    void delete(Movie movie);
}
