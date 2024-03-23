package az.edu.ada.spring.assignment.controller;

import az.edu.ada.spring.assignment.model.Actor;
import az.edu.ada.spring.assignment.repository.ActorRepository;
import az.edu.ada.spring.assignment.service.ActorService;
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

    @GetMapping("/actors/create")
    public String showActorForm(Model model) {
        model.addAttribute("actor", new Actor());
        return "actor/create";
    }

    // create POST method's view
    @PostMapping("/actors/create")
    public String createActor(@ModelAttribute Actor actor) {
        actorService.createActor(actor);
        return "redirect:/actors/index";
    }

    @GetMapping("/actors/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Actor actor = actorService.getActorById(id);
        model.addAttribute("actor", actor);
        return "actor/update";
    }

    // update POST method's view
    @PostMapping("/actors/update/{id}")
    public String updateActor(@PathVariable Long id, @ModelAttribute Actor actor) {
        actor.setId(id);
        actorService.updateActor(actor);
        return "redirect:/actors/index";
    }

    @GetMapping("/actors/delete/{id}")
    public String deleteActor(@PathVariable Long id) {
        actorService.deleteActorById(id);
        return "redirect:/actors/index";
    }
}
