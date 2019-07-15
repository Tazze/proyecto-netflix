package com.sopra.peliculas.modelo.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identificador;
	private String titulo;
	private String director;
	private String sinopsis;

	@ElementCollection(targetClass = Categoria.class)
	@Enumerated(EnumType.STRING)
	private List<Categoria> categorias;

	public Pelicula(){
		super();
	}

	public Pelicula(String titulo, String director){
		this.titulo = titulo;
		this.director = director;
	}

	public Pelicula(String titulo, String director, String sinopsis, List<Categoria> categorias){
		this.titulo = titulo;
		this.director = director;
		this.sinopsis = sinopsis;
		this.categorias = categorias;
	}
	
	public Integer getIdentificador() {
		return identificador;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pelicula [categorias=" + categorias + ", director=" + director + ", identificador=" + identificador
				+ ", sinopsis=" + sinopsis + ", titulo=" + titulo + "]";
	}

	
	
	
}
