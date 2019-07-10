package com.sopra.peliculas.dao;

import java.util.Collection;
import java.util.Map;

import com.sopra.peliculas.modelo.entities.Pelicula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class PeliculaMapDAO implements IPeliculaDAO {

	@Autowired
	@Qualifier("mapaPeliculas")
	private Map<Integer, Pelicula> catalogo;
	
	public PeliculaMapDAO(Map<Integer, Pelicula> catalogo) {
		this.catalogo = catalogo;
	}
	
	@Override
	public void create(Pelicula pelicula) {
		catalogo.putIfAbsent(pelicula.getIdentificador(), pelicula);
	}

	@Override
	public Collection<Pelicula> read() {
		return catalogo.values();
	}

	@Override
	public Pelicula update(Pelicula pelicula) {
		catalogo.replace(pelicula.getIdentificador(), pelicula);
		return catalogo.get(pelicula.getIdentificador());
	}

	@Override
	public void delete(Pelicula pelicula) {
		catalogo.remove(pelicula.getIdentificador(), pelicula);
	}

	@Override
	public Pelicula readById(Integer identificador) {
		return catalogo.get(identificador);
	}

}
