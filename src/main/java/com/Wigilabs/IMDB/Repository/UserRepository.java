/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Wigilabs.IMDB.Repository;

import com.Wigilabs.IMDB.Model.User;
import com.Wigilabs.IMDB.Repository.Crud.CrudUserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Camilo
 */
@Repository
public class UserRepository {

    @Autowired
    private CrudUserRepository repo;

    public List<User> getAll() {
        return repo.findAll();
    }

    public User save(User usuario) {
        return repo.save(usuario);
    }

    public void delete(User usuario) {
        repo.delete(usuario);
    }

    public Optional<User> getById(Integer id) {
        return repo.getById(id);
    }

    public Optional<User> getByEmail(String email) {
        return repo.findByEmail(email);
    }

    public Optional<User> getByEmailAndPassword(String email, String password) {
        return repo.findByEmailandPassword(email, password);
    }

}
