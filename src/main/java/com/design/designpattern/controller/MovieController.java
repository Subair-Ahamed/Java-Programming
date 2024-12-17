package com.design.designpattern.controller;

import com.design.designpattern.model.Movie;
import com.design.designpattern.service.CrudFactory;
import com.design.designpattern.service.CrudOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final List<Movie> storage = new ArrayList<>();

    @Autowired
    private CrudFactory factory;

    @PostMapping("/create")
    public String create(@RequestBody Movie movie) {
        CrudOperation operation = factory.getOperation("CREATE", storage, movie, null);
//        CrudOperation operation = new CreateOperation(new MovieLike(1, 101, 202, true));
        operation.execute();
        return "Movie created successfully!";
    }

    @GetMapping("/read")
    public String read() {
        CrudOperation operation = factory.getOperation("READ", storage, null, null);
        operation.execute();
        return "Read operation executed!";
    }

    @PutMapping("/update")
    public String update(@RequestBody Movie movie) {
        CrudOperation operation = factory.getOperation("UPDATE", storage, movie, null);
        operation.execute();
        return "Movie updated successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        CrudOperation operation = factory.getOperation("DELETE", storage, null, id);
        operation.execute();
        return "Movie deleted successfully!";
    }
}
