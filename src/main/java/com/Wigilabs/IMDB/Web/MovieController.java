/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Wigilabs.IMDB.Web;

import com.Wigilabs.IMDB.Model.Movie;
import com.Wigilabs.IMDB.Services.MovieService;
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
 * @author Camilo
 */
@RestController
@RequestMapping("/api/movie")
@CrossOrigin
public class MovieController {
    
    @Autowired
    private MovieService service;
    
    @GetMapping("/all")
    public List<Movie> getAll(){
        return service.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Movie> save(@RequestBody Movie usuario) {
        return new ResponseEntity(service.save(usuario), HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Movie> update(@RequestBody Movie usuario){
        return new ResponseEntity(service.update(usuario), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    
    /**
     * 
     * @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
     */
    
    //CONSULTA ID PUNTUAL
    
    @GetMapping("/{id}")
    private Movie getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }
        
        
  
      
}
