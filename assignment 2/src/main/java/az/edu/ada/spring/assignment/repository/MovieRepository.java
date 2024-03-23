package az.edu.ada.spring.assignment.repository;

import az.edu.ada.spring.assignment.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
