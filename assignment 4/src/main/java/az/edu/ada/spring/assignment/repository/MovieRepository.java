package az.edu.ada.spring.assignment.repository;

import az.edu.ada.spring.assignment.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}

