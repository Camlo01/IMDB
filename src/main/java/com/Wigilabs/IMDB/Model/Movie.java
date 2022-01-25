/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Wigilabs.IMDB.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * Los elementos de la tabla de datos 
 * 
 * @author Camilo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "movies") //nombre de la collecion en MongoDB
public class Movie {

    @Id
    private Integer id;
    private String title;
    private String poster;
    private String trailer;
    private String description;
    private int yearReleased; 
    private float rating;

}
