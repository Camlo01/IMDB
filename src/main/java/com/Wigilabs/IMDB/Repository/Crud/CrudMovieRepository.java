/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Wigilabs.IMDB.Repository.Crud;

import com.Wigilabs.IMDB.Model.Movie;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Camilo
 */
public interface CrudMovieRepository extends MongoRepository<Movie, Integer>{


    //
    @Query("{id: ?0}")
    Optional<Movie> getById(Integer id);

    @Query("{  'title' : ?0")
    Iterable<Movie> searchMovie(String phrase);
}

/**
 * Documentation @Query
 * https://docs.mongodb.com/manual/reference/operator/query/
 *
 */