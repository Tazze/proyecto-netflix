package com.sopra.peliculas.negocio;

import java.util.Collection;
import java.util.List;

import com.sopra.peliculas.dao.IPeliculaDAO;
import com.sopra.peliculas.modelo.entities.Pelicula;

public class GestorPeliculas {
	
	private IPeliculaDAO DAOPeliculas;
	
	public GestorPeliculas(IPeliculaDAO DAOPeliculas) {
		this.DAOPeliculas = DAOPeliculas;
	}
	
	public void altaPelicula(List<Pelicula> peliculas) {
		for(Pelicula p : peliculas) {
			DAOPeliculas.create(p);
		}
	}
	
	public Collection<Pelicula> listaPelicula() {
		return DAOPeliculas.read();
	}
	
	public void updatePelicula(List<Pelicula> peliculas) {
		for(Pelicula pelicula: peliculas) {
			DAOPeliculas.update(pelicula);
		}
	}
	
	public void deletePelicula(List<Integer> peliculas) {
		for(Integer pelicula : peliculas) {
			DAOPeliculas.delete(DAOPeliculas.readById(pelicula));
		}
	}
	
}
