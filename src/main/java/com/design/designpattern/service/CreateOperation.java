package com.design.designpattern.service;

import com.design.designpattern.model.Movie;

import java.util.List;

public class CreateOperation implements CrudOperation {

    private final List<Movie> storage;
    private final Movie movie;

    public CreateOperation(List<Movie> storage, Movie movie) {
        this.storage = storage;
        this.movie = movie;
    }

    @Override
    public void execute() {
        storage.add(movie);
        System.out.println("Created: " + movie);
    }
}
