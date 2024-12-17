package com.design.designpattern.service;

import com.design.designpattern.model.Movie;

import java.util.List;

public class ReadOperation implements CrudOperation {

    private final List<Movie> storage;

    public ReadOperation(List<Movie> storage) {
        this.storage = storage;
    }

    @Override
    public void execute() {
        if (storage.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        System.out.println("---- List of Movies ----");
        for (Movie movie : storage) {
            System.out.println("ID: " + movie.getId());
            System.out.println("Movie ID: " + movie.getMovieId());
            System.out.println("User ID: " + movie.getUserId());
            System.out.println("Liked: " + movie.isLiked());
            System.out.println("<<<<--------------------->>>>");
        }
    }
}
