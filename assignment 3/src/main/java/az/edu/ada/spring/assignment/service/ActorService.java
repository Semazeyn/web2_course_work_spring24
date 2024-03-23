package az.edu.ada.spring.assignment.service;

import az.edu.ada.spring.assignment.model.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> getAllActors();
    Actor getActorById(Long id);
    List<Actor> getActorsByMovieId(Long id);
    void createActor(Actor actor);
    void updateActor(Actor actor);
    void deleteActorById(Long id);
}
