/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Wigilabs.IMDB.Web;

import com.Wigilabs.IMDB.Model.User;
import com.Wigilabs.IMDB.Services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * La anotación @RestController marca la clase como un controlador donde
 * cada método devuelve un objeto de dominio en lugar de una vista
 * 
 * Simplemente envía el objeto de dominio como una respuesta HTTP
 * en el formato que entienden los consumidores, como JSON
 * 
 * @author Camilo
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<User> getAll() {
        return service.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> save(@RequestBody User usuario) {
        return new ResponseEntity(service.save(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> update(@RequestBody User usuario) {
        return new ResponseEntity(service.update(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    // CONSULTA POR ID PUNTUAL
    @GetMapping("/{id}")
    private User getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    // CONSULTA POR EMAIL-PASSWORD    
    @GetMapping("/{email}/{password}")
    private User getByEmail(@PathVariable("email") String email, @PathVariable("password") String password) {
        return service.getByEmailAndPassword(email, password);
    }

    // CONSULTA EMAIL
    @GetMapping("/emailexist/{email}")
    private boolean getByEmail(@PathVariable("email") String email) {
        return service.getByEmail(email);
    }

}
