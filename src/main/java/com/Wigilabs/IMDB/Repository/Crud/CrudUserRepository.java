/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Wigilabs.IMDB.Repository.Crud;

import com.Wigilabs.IMDB.Model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Camilo
 */
public interface CrudUserRepository extends MongoRepository<User, Integer>{

    @Query("{id: ?0}")
    public Optional<User> getById(Integer id);

    @Query("{id: ?0}")
    public Optional<User> getByid(Integer Id);
    
    @Query("{$and : [{email: {$lte: ?0}},{password: {$lte: ?1}}]}")
    public Optional<User> findByEmailandPassword(String email, String password);
}
