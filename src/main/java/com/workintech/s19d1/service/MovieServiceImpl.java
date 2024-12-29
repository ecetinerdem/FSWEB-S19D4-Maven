package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MovieServiceImpl implements MovieService{
    private final MovieRepository movieRepository;
    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new ApiException("Movie is not found " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Movie update(Long id, Movie movie) {
        Movie existingMovie = movieRepository.findById(id).orElseThrow(() -> new ApiException("Movie is not found with given id " + id, HttpStatus.NOT_FOUND));
        existingMovie.setName(movie.getName());
        existingMovie.setDirectorName(movie.getDirectorName());
        existingMovie.setRating(movie.getRating());
        existingMovie.setReleaseDate(movie.getReleaseDate());
        existingMovie.setActors(movie.getActors());

        return movieRepository.save(existingMovie);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }
}
