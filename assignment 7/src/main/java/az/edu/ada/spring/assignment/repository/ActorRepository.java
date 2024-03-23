package az.edu.ada.spring.assignment.repository;

import az.edu.ada.spring.assignment.model.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    // Find actors by movie ID
    @Query("SELECT a FROM Actor a JOIN a.movies b WHERE b.id = :movieId")
    List<Actor> findByMoviesId(@Param("movieId") Long movieId);

    // Find actors by nationality with pagination
    @Query("SELECT a FROM Actor a WHERE a.nationality = :nationality")
    Page<Actor> findByNationality(String nationality, Pageable pageable);

    // Find all distinct nationalities of actors
    @Query("SELECT DISTINCT a.nationality FROM Actor a")
    Iterable<String> findAllDistinctNationalities();
}
