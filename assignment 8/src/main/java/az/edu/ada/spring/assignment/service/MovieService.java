package az.edu.ada.spring.assignment.service;

import az.edu.ada.spring.assignment.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {
    // Retrieve all movies with pagination
    Page<Movie> getAllMovies(Pageable pageable);

    // Retrieve a movie by its ID
    Movie getMovieById(Long id);

    // Create a new movie
    void createMovie(Movie movie);

    // Delete a movie by its ID
    void deleteMovieById(Long id);

    // Update an existing movie
    void updateMovie(Movie movie);

    // Retrieve movies by genre with pagination
    Page<Movie> findByGenre(String genre, Pageable pageable);

    // Retrieve all distinct genres
    List<String> getAllDistinctGenres();
}
