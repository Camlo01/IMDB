/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Wigilabs.IMDB.Services;

import com.Wigilabs.IMDB.Model.Movie;
import com.Wigilabs.IMDB.Repository.MovieRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  
 *  Se implementa la lógica de negocio también
 * identificada por la anotación @Autowired
 * 
 * @author Camilo
 */
@Service 
public class MovieService {

    @Autowired
    private MovieRepository repo;

    
    public List<Movie> getAll() {
        return repo.getAll();
    }

    public Movie save(Movie movie) {
        return repo.save(movie);
    }

    public void delete(Integer id) {
        Optional<Movie> element = repo.getById(id);
        if (element.isPresent()) {
            repo.delete(element.get());
        }
    }

    public Movie update(Movie movie) {
        Optional<Movie> element = repo.getById(movie.getId());
        if (element.isPresent()) {

            Movie upd = element.get();

            if (movie.getTitle() != null && movie.getTitle().length() > 0) {
                upd.setTitle(movie.getTitle());
            }
            if (movie.getPoster() != null && movie.getPoster().length() > 0) {
                upd.setPoster(movie.getPoster());
            }
            if (movie.getTrailer() != null && movie.getTrailer().length() > 0) {
                upd.setTrailer(movie.getTrailer());
            }
            if (movie.getDescription() != null && movie.getDescription().length() > 0) {
                upd.setDescription(movie.getDescription());
            }
            // YEAR REALASED 

            if (movie.getYearReleased() != 0 && movie.getYearReleased() > 0) {
                upd.setYearReleased(movie.getYearReleased());
            }
            if (movie.getRating() != 0 && movie.getRating() > 0) {
                upd.setRating(movie.getRating());
            }
            return movie;
        }
        return movie;
    }

    public Movie getById(Integer id) {
        Optional<Movie> movie = repo.getById(id);
        if (movie.isPresent()) {
            return movie.get();
        } else {
            Movie Mov = new Movie();
            return Mov;
        }
    }

}
