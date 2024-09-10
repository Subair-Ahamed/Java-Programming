package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Movie() {
    }

    private String director;
    private String name;
    private String actor;

    public Movie(String actor, String name, String director, Integer id) {
        this.actor = actor;
        this.name = name;
        this.director = director;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getDirector() {
        return director;
    }

    public String getName() {
        return name;
    }

    public String getActor() {
        return actor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
