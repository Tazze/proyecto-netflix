package com.sopra.peliculas.restjpa.model;

import com.sopra.peliculas.restjpa.model.entities.Pelicula;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Pelicula, Integer> {
    
}