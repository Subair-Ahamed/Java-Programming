package com.example.demo.service;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Integer id){
        return movieRepository.findById(Long.valueOf(id));
    }

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    // Update existing movie
    public Movie updateMovie(Integer id, Movie updatedMovie) {
        return movieRepository.findById(Long.valueOf(id))
                .map(movie -> {
                    movie.setName(updatedMovie.getName());
                    movie.setDirector(updatedMovie.getDirector());
                    movie.setActor(updatedMovie.getActor());
                    return movieRepository.save(movie);  // Save the updated movie back to the database
                })
                .orElseThrow(() -> new RuntimeException("Movie not found with id " + id));
    }

    public void deleteMovie(Integer id){
        movieRepository.deleteById(Long.valueOf(id));
    }

    public List<Movie> searchMovie(String searchQuery){
        return movieRepository.searchByTerm(searchQuery);
    }
}
