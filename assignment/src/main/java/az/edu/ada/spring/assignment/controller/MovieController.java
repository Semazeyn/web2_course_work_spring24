package az.edu.ada.spring.assignment.controller;

import az.edu.ada.spring.assignment.model.Movie;
import az.edu.ada.spring.assignment.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies/index")
    public String getAllMovies(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movie/index";
    }

    @GetMapping("/movies/detail/{id}")
    public String getMovieDetail(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "movie/detail";
    }
}
