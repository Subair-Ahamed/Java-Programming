package com.design.designpattern.service;

import com.design.designpattern.model.Movie;

import java.util.List;

public class UpdateOperation implements CrudOperation {

    private final List<Movie> storage;
    private final Movie updatedMovie;

    public UpdateOperation(List<Movie> storage, Movie updatedMovie) {
        this.storage = storage;
        this.updatedMovie = updatedMovie;
    }

    @Override
    public void execute() {
        for (Movie movie : storage) {
            if (movie.getId() == updatedMovie.getId()) {
                movie.setMovieId(updatedMovie.getMovieId());
                movie.setUserId(updatedMovie.getUserId());
                movie.setLiked(updatedMovie.isLiked());
                System.out.println("Updated: " + movie);
                return;
            }
        }
        System.out.println("Movie not found for update.");
    }
}
