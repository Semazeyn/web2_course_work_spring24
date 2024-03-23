package az.edu.ada.spring.assignment.service;

import az.edu.ada.spring.assignment.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    void createMovie(Movie movie);
}
