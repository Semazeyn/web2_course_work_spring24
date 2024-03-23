package az.edu.ada.spring.assignment.controller;

import az.edu.ada.spring.assignment.model.Actor;
import az.edu.ada.spring.assignment.repository.ActorRepository;
import az.edu.ada.spring.assignment.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ActorController {
    @Autowired
    private ActorService actorService;

    // Retrieves all actors with pagination, sorting, and optional nationality filter
    @GetMapping("/actors/index")
    public String getAllActorsPaginatedAndFiltered(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "3") int size,
                                @RequestParam(defaultValue = "id,asc") String sortBy,
                                @RequestParam(defaultValue = "") String nationality,
                                Model model) {
        if (sortBy.isEmpty()) {
            sortBy = "id,asc";
        }

        String[] sortParams = sortBy.split(",");
        String sortField = sortParams[0];
        Sort.Direction sortDirection = sortParams.length > 1 && sortParams[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, sortDirection, sortField);
        Page<Actor> actorPage;
        if (nationality.isEmpty()) {
            actorPage = actorService.getAllActors(pageable);
        } else {
            actorPage = actorService.findByNationality(nationality, pageable);
        }

        List<String> nationalities = actorService.getAllDistinctNationalities();

        model.addAttribute("actors", actorPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", actorPage.getTotalPages());
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("nationality", nationality.isEmpty() ? "" : nationality);
        model.addAttribute("nationalities", nationalities);
        return "actor/index";
    }

    // Retrieves the details of a specific actor by ID
    @GetMapping("/actors/detail/{id}")
    public String getActorDetailById(@PathVariable("id") Long id, Model model) {
        Actor actor = actorService.getActorById(id);
        model.addAttribute("actor", actor);
        return "actor/detail";
    }

    // Displays the form for creating a new actor
    @GetMapping("/actors/create")
    public String showCreateActorForm(Model model) {
        model.addAttribute("actor", new Actor());
        return "actor/create";
    }

    // Creates a new actor
    @PostMapping("/actors/create")
    public String createNewActor(@ModelAttribute Actor actor) {
        actorService.createActor(actor);
        return "redirect:/actors/index";
    }

    // Displays the form for updating an existing actor
    @GetMapping("/actors/update/{id}")
    public String showUpdateActorForm(@PathVariable Long id, Model model) {
        Actor actor = actorService.getActorById(id);
        model.addAttribute("actor", actor);
        return "actor/update";
    }

    // Updates an existing actor
    @PostMapping("/actors/update/{id}")
    public String updateExistingActor(@PathVariable Long id, @ModelAttribute Actor actor) {
        actor.setId(id);
        actorService.updateActor(actor);
        return "redirect:/actors/index";
    }

    // Deletes an actor by ID
    @GetMapping("/actors/delete/{id}")
    public String deleteActorById(@PathVariable Long id) {
        actorService.deleteActorById(id);
        return "redirect:/actors/index";
    }
}
