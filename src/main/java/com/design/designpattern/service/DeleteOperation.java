package com.design.designpattern.service;

import com.design.designpattern.model.Movie;

import java.util.List;

public class DeleteOperation implements CrudOperation {

    private final List<Movie> storage;
    private final int id;

    public DeleteOperation(List<Movie> storage, int id) {
        this.storage = storage;
        this.id = id;
    }

    @Override
    public void execute() {
        storage.removeIf(movie -> movie.getId() == id);
        System.out.println("Deleted Movie with ID: " + id);
    }
}
