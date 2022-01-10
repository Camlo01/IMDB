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

    public User update(User usuario) {
        Optional<User> ou = repo.getById(usuario.getId());
        if (ou.isPresent()) {
            User act = ou.get();
            //validacion para no actualizar datos nulos o vacios
            if (usuario.getId() != null) {
                act.setId(usuario.getId());
            }

            if (usuario.getEmail() != null && usuario.getEmail().length() > 0) {
                act.setEmail(usuario.getEmail());
            }
            if (usuario.getPassword() != null && usuario.getPassword().length() > 0) {
                act.setPassword(usuario.getPassword());
            }

            return repo.save(act);
        }
        return usuario;
    }

    public User getByEmailAndPassword(String email, String password) {
        Optional<User> user = repo.getByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return user.get();
        } else {
            User e = new User();
            return e;
        }
    }

    public boolean getByEmail(String email) {
        Optional<User> user = repo.getByEmail(email);
        return user.isPresent();
    }

    public User getById(Integer id) {
        Optional<User> user = repo.getById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            User e = new User();
            return e;
        }
    }

}
