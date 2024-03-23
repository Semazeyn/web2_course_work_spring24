package az.edu.ada.spring.assignment.controller;

import az.edu.ada.spring.assignment.model.Actor;
import az.edu.ada.spring.assignment.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @GetMapping("/actors")
    public String getAllActors(Model model) {
        List<Actor> actors = actorRepository.findAll();
        model.addAttribute("actors", actors);
        return "actor/index";
    }

    @GetMapping("/actors/{id}")
    public String getActorById(@PathVariable Long id, Model model) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid actor ID"));
        model.addAttribute("actor", actor);
        return "actor/detail";
    }
}
