package az.edu.ada.spring.assignment.controller;

import az.edu.ada.spring.assignment.model.Actor;
import az.edu.ada.spring.assignment.model.Movie;
import az.edu.ada.spring.assignment.service.ActorService;
import az.edu.ada.spring.assignment.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private ActorService actorService;

    // Retrieves all movies with pagination, sorting, and optional genre filter
    @GetMapping("/movies/index")
    public String getAllMoviesPaginatedAndFiltered(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size,
                              @RequestParam(defaultValue = "id,desc") String sortBy,
                              @RequestParam(defaultValue = "") String genre,
                              Model model) {
        if (sortBy.isEmpty()) {
            sortBy = "id,desc";
        }

        String[] sortParams = sortBy.split(",");
        String sortField = sortParams[0];
        Sort.Direction sortDirection = sortParams.length > 1 && sortParams[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable;
        if (sortField.equals("name")) {
            pageable = PageRequest.of(page, size, sortDirection, "name");
        } else {
            pageable = PageRequest.of(page, size, sortDirection, sortField);
        }

        Page<Movie> moviePage;
        if (genre.isEmpty()) {
             moviePage = movieService.getAllMovies(pageable);
        } else {
            moviePage = movieService.findByGenre(genre, pageable);
        }

        List<String> genres = movieService.getAllDistinctGenres();

        model.addAttribute("movies", moviePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", moviePage.getTotalPages());
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("genre", genre.isEmpty() ? "" : genre);
        model.addAttribute("genres", genres);
        return "movie/index";
    }

    // Retrieves the details of a specific movie by ID
    @GetMapping("/movies/detail/{id}")
    public String getMovieDetailById(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        model.addAttribute("actors", actorService.getActorsByMovieId(id));
        return "movie/detail";
    }

    // Displays the form for creating a new movie
    @GetMapping("/movies/create")
    public String showCreateMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("actors", actorService.getAllActors());
        return "movie/create";
    }

    // Creates a new movie
    @PostMapping("/movies/create")
    public String createNewMovie(@ModelAttribute Movie movie) {
        movieService.createMovie(movie);
        return "redirect:/movies/index";
    }

    // Displays the form for updating an existing movie
    @GetMapping("/movies/update/{id}")
    public String showUpdateMovieForm(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        model.addAttribute("allActors", actorService.getActorsByMovieId(id));
        return "movie/update";
    }

    // Updates an existing movie
    @PostMapping("/movies/update/{id}")
    public String updateExistingMovie(@PathVariable Long id, @ModelAttribute Movie movie) {
        movie.setId(id);
        movieService.updateMovie(movie);
        return "redirect:/movies/index";
    }

    // Deletes a movie by ID
    @GetMapping("/movies/delete/{id}")
    public String deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return "redirect:/movies/index";
    }
}
