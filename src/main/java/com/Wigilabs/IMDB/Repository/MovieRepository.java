/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Wigilabs.IMDB.Repository;

import com.Wigilabs.IMDB.Model.Movie;
import com.Wigilabs.IMDB.Repository.Crud.CrudMovieRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * Se permite el acceso a la base de datos gracias a la
 * anotación @Repository
 * 
 * @author Camilo
 */
@Repository
public class MovieRepository {

    @Autowired
    private CrudMovieRepository repo;

    //Traer TODOS los elementos
    public List<Movie> getAll() {
        return repo.findAll();
    }

    //Traer elementos
    public List<Movie> searchMovie(String text){
        return (List<Movie>) repo.searchMovie(text);
    }

    //Traer un elemento por el ID
    public Optional<Movie> getById(Integer id) {
        return repo.getById(id);
    }

    //Guardar un elemento
    public Movie save(Movie movie) {
        return repo.save(movie);
    }

    //Eliminar un elemento
    public void delete(Movie movie) {
        repo.delete(movie);
    }

}
