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
@Document(collection = "users")  //nombre de la collecion en MongoDB
public class User {

    @Id
    private Integer id;
    private String email;
    private String password;
}
