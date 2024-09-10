package com.example.demo.controller;

import com.example.demo.entity.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMoviesById(@PathVariable("id") Integer id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        return movie.map(ResponseEntity::ok) // If movie is found, return 200 OK with movie data
                .orElseGet(() -> ResponseEntity.notFound().build()); // If movie not found, return 404 Not Found
    }

    @PostMapping
    public Movie saveMovie(@RequestBody Movie movie){
        return  movieService.saveMovie(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Integer id, @RequestBody Movie updatedMovie) {
        try {
            Movie movie = movieService.updateMovie(id, updatedMovie);
            return ResponseEntity.ok(movie);  // Return updated movie with status 200 OK
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();  // Return 404 if movie is not found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") Integer id){
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            movieService.deleteMovie(id);
            return ResponseEntity.noContent().build(); // Return 204 No Content if successful
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if movie not found
        }
    }
}
