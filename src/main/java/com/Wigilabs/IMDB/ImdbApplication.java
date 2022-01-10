package com.Wigilabs.IMDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(basePackages = {"com.Wigilabs.IMDB"})
public class ImdbApplication {

    @Autowired
    //private MovieRepository repoMovie;
    //private UserRepository repoUser;

    public static void main(String[] args) {
        SpringApplication.run(ImdbApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            System.out.println("APLICACIÓN INICIADA");

            //List<Movie> mov = repoMovie.getAll();
            //System.out.println("Movies "+ mov.size());
            
            //List<User> use = repoUser.getAll();
            //System.out.println("Users =" + use.size());
        };
    }
    
   @Bean
   public WebMvcConfigurer corsConfigurer(){
       return new WebMvcConfigurer(){
           @Override
           public void addCorsMappings(CorsRegistry registry){
               registry.addMapping("/**").allowedOrigins("*");
           }
       };
       
   }

}
