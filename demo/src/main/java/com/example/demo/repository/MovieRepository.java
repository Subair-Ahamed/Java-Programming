package com.example.demo.repository;

import com.example.demo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository <Movie, Long> {
    @Query("SELECT m FROM Movie m WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :text, '%')) OR LOWER(m.actor) LIKE LOWER(CONCAT('%', :text, '%')) OR LOWER(m.director) LIKE LOWER(CONCAT('%', :text, '%'))")
    List<Movie> searchByTerm(@Param("text") String searchQuery);
}
