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

   public Optional<User> findByEmail(String email); 

    @Query("{id: ?0}")
    public Optional<User> getById(Integer id);  
    
    //{$and : Joins query clauses with a logical AND returns all documents that match the conditions of both clauses.
    
    //{email: {$lte: ?0}} FROM Email select the document WHERE the value in the field is less or equal to (1 in this case) 
    //{password: {$lte: ?1}}]} FROM Password select the document WHERE the value in the field is less or equal to (1 in this case) 
    @Query("{$and : [{email: {$lte: ?0}},{password: {$lte: ?1}}]}")
    public Optional<User> findByEmailandPassword(String email, String password);
}

/**
 * Documentation @Query
 * https://docs.mongodb.com/manual/reference/operator/query/
 * 
 */
