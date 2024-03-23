package az.edu.ada.spring.assignment.service.Impl;

import az.edu.ada.spring.assignment.model.Movie;
import az.edu.ada.spring.assignment.service.MovieService;
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
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
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
}
