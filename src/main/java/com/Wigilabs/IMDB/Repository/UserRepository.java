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
 * Se permite el acceso a la base de datos gracias a la
 * anotación @Repository
 * 
 * @author Camilo
 */
@Repository
public class UserRepository {

    @Autowired
    private CrudUserRepository repo;
    
    //Traer todos los usuarios   
    public List<User> getAll() {
        return repo.findAll();
    }

    //Guardar el usuario creado
    public User save(User usuario) {
        return repo.save(usuario);
    }

    //Se elimina usuario
    public void delete(User usuario) {
        repo.delete(usuario);
    }

    //Se trae el usuario por el id
    public Optional<User> getById(Integer id) {
        return repo.getById(id);
    }

    //Se trae el usuario por el correo
    public Optional<User> getByEmail(String email) {
        return repo.findByEmail(email);
    }

    //Se trae el Email y la Password
    public Optional<User> getByEmailAndPassword(String email, String password) {
        return repo.findByEmailandPassword(email, password);
    }

}
