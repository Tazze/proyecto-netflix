package com.sopra.peliculas.dao;

import java.util.Collection;
import java.util.Map;

import com.sopra.peliculas.modelo.entities.Pelicula;

public class PeliculaMapDAO implements IPeliculaDAO {

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
