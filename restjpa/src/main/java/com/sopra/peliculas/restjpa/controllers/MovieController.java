package com.sopra.peliculas.restjpa.controllers;

import java.util.List;

import com.sopra.peliculas.restjpa.model.MovieRepository;
import com.sopra.peliculas.restjpa.model.entities.Pelicula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController{


    @Autowired
    private MovieRepository repository;

    @GetMapping("/repositorio")
    public List<Pelicula> listMovies(){
        return repository.findAll();
    }

    @PostMapping("/repositorio")
    public Pelicula addMovie(@RequestBody Pelicula pelicula){
        return repository.save(pelicula);
    }
    
    public MovieRepository getRepository() {
        return repository;
    }

    public void setRepository(MovieRepository repository) {
        this.repository = repository;
    }

    
}