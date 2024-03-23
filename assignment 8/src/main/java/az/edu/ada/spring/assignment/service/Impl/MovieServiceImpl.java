package az.edu.ada.spring.assignment.service.Impl;

import az.edu.ada.spring.assignment.model.Actor;
import az.edu.ada.spring.assignment.model.Movie;
import az.edu.ada.spring.assignment.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import az.edu.ada.spring.assignment.model.Movie;
import az.edu.ada.spring.assignment.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Page<Movie> getAllMovies(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    public Movie getMovieById(Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        return optionalMovie.orElse(null);
    }

    @Override
    public void createMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public Page<Movie> findByGenre(String genre, Pageable pageable) {
        return movieRepository.findByGenre(genre, pageable);
    }

    @Override
    public List<String> getAllDistinctGenres() {
        return movieRepository.findDistinctGenres();
    }
}
