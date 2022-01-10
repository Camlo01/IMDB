package com.Wigilabs.IMDB;

//import com.Wigilabs.IMDB.Model.Movie;
//import com.Wigilabs.IMDB.Model.User;
//import com.Wigilabs.IMDB.Repository.MovieRepository;
//import com.Wigilabs.IMDB.Repository.UserRepository;
//import java.util.List;
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

            //Si aparece el caracol significa que la aplicación está funcionado
            System.out.println("    o       o");
            System.out.println("     \\_____/");
            System.out.println("     /=O=O=\\     _______");
            System.out.println("    /   ^   \\   /\\\\\\\\\\\\\\\\");
            System.out.println("    \\ \\___/ /  /\\   ___  \\");
            System.out.println("     \\_ V _/  /\\   /\\\\\\\\  \\");
            System.out.println("       \\  \\__/\\   /\\ @_/  /");
            System.out.println("        \\____\\____\\______/");
            System.out.println("");

            //List<Movie> mov = repoMovie.getAll();
            //System.out.println("Movies "+ mov.size());
            //List<User> use = repoUser.getAll();
            //System.out.println("Users =" + use.size());
        };
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };

    }

}
