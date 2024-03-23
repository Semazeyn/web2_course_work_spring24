package az.edu.ada.spring.assignment.service;

import az.edu.ada.spring.assignment.model.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ActorService {
    // Retrieve all actors
    List<Actor> getAllActors();

    // Retrieve all actors with pagination
    Page<Actor> getAllActors(Pageable pageable);

    // Retrieve an actor by its ID
    Actor getActorById(Long id);

    // Retrieve actors by movie ID
    List<Actor> getActorsByMovieId(Long id);

    // Create a new actor
    void createActor(Actor actor);

    // Update an existing actor
    void updateActor(Actor actor);

    // Delete an actor by its ID
    void deleteActorById(Long id);

    // Retrieve actors by nationality with pagination
    Page<Actor> findByNationality(String nationality, Pageable pageable);

    // Retrieve all distinct nationalities
    List<String> getAllDistinctNationalities();
}
