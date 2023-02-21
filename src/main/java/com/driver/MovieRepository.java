package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieHashMap = new HashMap<>();
    HashMap<String, Director> directorHashMap = new HashMap<>();

    HashMap<String, List<String>> movieDirectorHashMap = new HashMap<>();

    public void addMovie(Movie movie){
        String name = movie.getName();
        movieHashMap.put(name,movie);
    }

    public void addDirector(Director director){
        String name = director.getName();
        directorHashMap.put(name, director);
    }

    public void addMovieDirectorPair(String movieName, String directorName){
        List<String> moviesList = new ArrayList<>();
        if(movieDirectorHashMap.containsKey(directorName)){
            moviesList = movieDirectorHashMap.get(directorName);
            moviesList.add(movieName);
            movieDirectorHashMap.put(directorName,moviesList);
        }
        else{
            moviesList.add(movieName);
            movieDirectorHashMap.put(directorName,moviesList);
        }
    }

    public  Movie getMovieByName(String movieName){
        if (movieHashMap.containsKey(movieName)){
            return movieHashMap.get(movieName);
        }
        else {
            return null;
        }
    }

    public  Director getDirectorByName(String directorName){
        if (directorHashMap.containsKey(directorName)){
            return directorHashMap.get(directorName);
        }
        else {
            return null;
        }
    }

    public List<String> getMoviesByDirectorName(String directorName){
        if(movieDirectorHashMap.containsKey(directorName)){
            return movieDirectorHashMap.get(directorName);
        }
        else{
            return null;
        }
    }

    public List<Movie> findAllMovies(){
        List<Movie> moviesList = new ArrayList<>();

        for (Map.Entry<String,Movie> movieEntry : movieHashMap.entrySet()){
            moviesList.add(movieEntry.getValue());
        }
        return moviesList;
    }

    public void deleteDirectorByName(String directorName){
        if (directorHashMap.containsKey(directorName)){
            directorHashMap.remove(directorName);
        }
    }

    public void deleteAllDirectors(){
        directorHashMap.clear();
        movieDirectorHashMap.clear();
    }
}
