package az.edu.ada.spring.assignment.controller;

import az.edu.ada.spring.assignment.model.Movie;
import az.edu.ada.spring.assignment.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public String getAllMovies(Model model) {
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        return "movie/index";
    }

    @GetMapping("/movies/{id}")
    public String getMovieById(@PathVariable Long id, Model model) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid movie ID"));
        model.addAttribute("movie", movie);
        return "movie/detail";
    }
}
