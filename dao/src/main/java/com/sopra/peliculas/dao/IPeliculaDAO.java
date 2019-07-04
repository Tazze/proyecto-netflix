package com.sopra.peliculas.dao;

import java.util.Collection;

import com.sopra.peliculas.modelo.entities.Pelicula;

public interface IPeliculaDAO {
public void create(Pelicula pelicula);
public Collection<Pelicula> read();
public Pelicula update(Pelicula pelicula);
public void delete(Pelicula pelicula);
public Pelicula readById(Integer identificador);

}
