package com.sopra.peliculas.modelo.entities;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Pelicula {
	private static AtomicInteger secuencia;
	private Integer identificador;
	private String titulo;
	private String director;
	private String sinopsis;
	List<Categoria> categorias;
	
	static {
		secuencia = new AtomicInteger();
	}
	
	public Pelicula() {
		identificador = secuencia.getAndIncrement();
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
