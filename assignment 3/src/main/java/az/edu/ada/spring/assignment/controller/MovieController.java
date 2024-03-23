package az.edu.ada.spring.assignment.controller;

import az.edu.ada.spring.assignment.model.Actor;
import az.edu.ada.spring.assignment.model.Movie;
import az.edu.ada.spring.assignment.service.ActorService;
import az.edu.ada.spring.assignment.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private ActorService actorService;

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
        model.addAttribute("actors", actorService.getActorsByMovieId(id));
        return "movie/detail";
    }

    @GetMapping("/movies/create")
    public String showMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("actors", actorService.getAllActors());
        return "movie/create";
    }

    @PostMapping("/movies/create")
    public String createMovie(@ModelAttribute Movie movie) {
        movieService.createMovie(movie);
        return "redirect:/movies/index";
    }

    @GetMapping("/movies/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        model.addAttribute("allActors", actorService.getActorsByMovieId(id));
        return "movie/update";
    }


    // Mapping for handling update of an existing book
    @PostMapping("/movies/update/{id}")
    public String updateMovie(@PathVariable Long id, @ModelAttribute Movie movie) {
        movie.setId(id);
        movieService.updateMovie(movie);
        return "redirect:/movies/index";
    }

    // Mapping for deleting a book
    @GetMapping("/movies/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return "redirect:/movies/index";
    }
}
