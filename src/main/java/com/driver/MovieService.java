package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;


@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movie_name, String director_name){
        movieRepository.addMovieDirectorPair(movie_name,director_name);
    }

    public Movie getMovieByName(String movie_name){
        return movieRepository.getMovieByName(movie_name);
    }

    public Director getDirectorByName(String directorName){
        return movieRepository.getDirectorByName(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName){
        return movieRepository.getMoviesByDirectorName(directorName);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorByName(String director_name){
        movieRepository.deleteDirectorByName(director_name);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
}
