package az.edu.ada.spring.assignment.repository;

import az.edu.ada.spring.assignment.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Query("SELECT a FROM Actor a JOIN a.movies b WHERE b.id = :movieId")
    List<Actor> findByMoviesId(@Param("movieId") Long movieId);
}
