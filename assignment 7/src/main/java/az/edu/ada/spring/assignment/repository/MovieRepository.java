package az.edu.ada.spring.assignment.repository;

import az.edu.ada.spring.assignment.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Find movies by genre with pagination
    @Query("SELECT b FROM Movie b WHERE b.genre = :genre")
    Page<Movie> findByGenre(String genre, Pageable pageable);

    // Find all distinct genres of movies
    @Query("SELECT DISTINCT b.genre FROM Movie b")
    List<String> findDistinctGenres();
}

