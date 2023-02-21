package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieHashMap = new HashMap<>();
    HashMap<String, Director> directorHashMap = new HashMap<>();

    public void addMovie(Movie movie){
        String name = movie.getName();
        movieHashMap.put(name,movie);
    }

    public void addDirector(Director director){
        String name = director.getName();
        directorHashMap.put(name, director);
    }
}
