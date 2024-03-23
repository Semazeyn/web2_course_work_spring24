package az.edu.ada.spring.assignment.repository;

import az.edu.ada.spring.assignment.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
