package com.design.designpattern.service;

import com.design.designpattern.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrudFactory {
    public CrudOperation getOperation(String type, List<Movie> storage, Movie movie, Integer id) {
        switch (type.toUpperCase()) {
            case "CREATE":
                return new CreateOperation(storage, movie);
            case "READ":
                return new ReadOperation(storage);
            case "UPDATE":
                return new UpdateOperation(storage, movie);
            case "DELETE":
                return new DeleteOperation(storage, id);
            default:
                throw new IllegalArgumentException("Invalid operation type: " + type);
        }
    }
}
