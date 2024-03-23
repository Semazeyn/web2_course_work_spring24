package az.edu.ada.spring.assignment.service;

import az.edu.ada.spring.assignment.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Page<Movie> getAllMovies(Pageable pageable);
    Movie getMovieById(Long id);
    void createMovie(Movie movie);
    void deleteMovieById(Long id);
    void updateMovie(Movie movie);
    Page<Movie> findByGenre(String genre, Pageable pageable);
    List<String> getAllDistinctGenres();
}
