/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Wigilabs.IMDB.Services;

import com.Wigilabs.IMDB.Model.User;
import com.Wigilabs.IMDB.Repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Camilo
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> getAll() {
        return repo.getAll();
    }

    public User save(User usuario) {
        return repo.save(usuario);
    }

    public void delete(Integer id) {
        Optional<User> us = repo.getById(id);
        if (us.isPresent()) {
            repo.delete(us.get());
        }

    }

}
