package com.example.demo.service;

import com.example.demo.dto.PaginationData;
import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public PaginationData getMovies(int offset, int limit){
        Page<Movie> list = movieRepository.findAll(PageRequest.of(offset - 1, limit));
        List<Movie> data = list.getContent();
        return new PaginationData(
                data,
                list.getNumber() + 1,
                data.size(),
                list.getTotalPages(),
                list.getTotalElements()
        );
    }

    public Optional<Movie> getMovieById(Integer id){
        return movieRepository.findById(Long.valueOf(id));
    }

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Integer id, Movie updatedMovie) {
        Movie movieData = movieRepository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException("Movie not found with id " + id));
        BeanUtils.copyProperties(updatedMovie, movieData);
        return movieRepository.save(movieData);
    }

    public void deleteMovie(Integer id){
        movieRepository.deleteById(Long.valueOf(id));
    }

    public List<Movie> searchMovie(String searchQuery){
        return movieRepository.searchByTerm(searchQuery);
    }
}
