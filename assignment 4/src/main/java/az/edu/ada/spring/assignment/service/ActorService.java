package az.edu.ada.spring.assignment.service;

import az.edu.ada.spring.assignment.model.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ActorService {
    List<Actor> getAllActors();
    Page<Actor> getAllActors(Pageable pageable);
    Actor getActorById(Long id);
    List<Actor> getActorsByMovieId(Long id);
    void createActor(Actor actor);
    void updateActor(Actor actor);
    void deleteActorById(Long id);

    Page<Actor> findByNationality(String nationality, Pageable pageable);
    List<String> getAllDistinctNationalities();
}
