package com.sopra.peliculas.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sopra.peliculas.dao.IPeliculaDAO;
import com.sopra.peliculas.dao.PeliculaMapDAO;
import com.sopra.peliculas.modelo.entities.Categoria;
import com.sopra.peliculas.modelo.entities.Pelicula;
import com.sopra.peliculas.negocio.GestorPeliculas;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig{

    @Bean("pelicula")
    @Scope("prototype")
    public Pelicula getPelicula(){
        Pelicula pelicula = new Pelicula();
        pelicula.setCategorias(new ArrayList<Categoria>());
        pelicula.setDirector("director");
        pelicula.setSinopsis("sinopsis");
        pelicula.setTitulo("titulo");
        return pelicula;
    }

    @Bean("mapa")
    @Scope("prototype")
    public Map<Integer, Pelicula> getMap(){
        return new HashMap<Integer, Pelicula>();
    }

    @Bean("listaPeliculas")
    @Scope("prototype")
    public List<Pelicula> getList(){
        return new ArrayList<Pelicula>();
    }

    @Bean("daoPeliculas")
    @Scope("singleton")
    public IPeliculaDAO getDAOpeliculas(@Qualifier("mapa") Map<Integer, Pelicula> mapa){
        return new PeliculaMapDAO(mapa);
    }

    @Bean("gestorPeliculas")
    public GestorPeliculas getGestorPeliculas(@Qualifier("daoPeliculas") IPeliculaDAO dao){
        return new GestorPeliculas(dao);
    }

}