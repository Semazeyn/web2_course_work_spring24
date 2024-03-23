package az.edu.ada.spring.assignment.controller;

import az.edu.ada.spring.assignment.model.Actor;
import az.edu.ada.spring.assignment.repository.ActorRepository;
import az.edu.ada.spring.assignment.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/actors/index")
    public String getAllActors(Model model) {
        List<Actor> actors = actorService.getAllActors();
        model.addAttribute("actors", actors);
        return "actor/index";
    }

    @GetMapping("/actors/detail/{id}")
    public String getActorById(@PathVariable("id") Long id, Model model) {
        Actor actor = actorService.getActorById(id);
        model.addAttribute("actor", actor);
        return "actor/detail";
    }
}
