package az.edu.ada.spring.assignment.service.Impl;

import az.edu.ada.spring.assignment.model.Actor;
import az.edu.ada.spring.assignment.repository.ActorRepository;
import az.edu.ada.spring.assignment.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
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
}