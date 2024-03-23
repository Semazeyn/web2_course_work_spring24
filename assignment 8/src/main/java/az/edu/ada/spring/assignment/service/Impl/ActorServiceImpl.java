package az.edu.ada.spring.assignment.service.Impl;

import az.edu.ada.spring.assignment.model.Actor;
import az.edu.ada.spring.assignment.repository.ActorRepository;
import az.edu.ada.spring.assignment.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Page<Actor> getAllActors(Pageable pageable) {
        return actorRepository.findAll(pageable);
    }

    @Override
    public Actor getActorById(Long id) {
        Optional<Actor> optionalActor = actorRepository.findById(id);
        return optionalActor.orElse(null);
    }

    @Override
    public void createActor(Actor actor) {
        actorRepository.save(actor);
    }

    @Override
    public void updateActor(Actor actor) {
        actorRepository.save(actor);
    }

    @Override
    public void deleteActorById(Long id) {
        actorRepository.deleteById(id);
    }

    @Override
    public List<Actor> getActorsByMovieId(Long id){
        return (List<Actor>) actorRepository.findByMoviesId(id);
    }

    @Override
    public Page<Actor> findByNationality(String nationality, Pageable pageable) {
        return actorRepository.findByNationality(nationality, pageable);
    }

    public List<String> getAllDistinctNationalities() {
        return (List<String>) actorRepository.findAllDistinctNationalities();
    }
}