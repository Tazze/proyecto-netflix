package com.sopra.peliculas.web.wrappers;

import java.util.concurrent.ConcurrentHashMap;

import com.sopra.peliculas.modelo.entities.Pelicula;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("mapaPeliculas")
@Scope("prototype")
public class MapaPeliculas extends ConcurrentHashMap<Integer, Pelicula> {

    private static final long serialVersionUID = 1L;
    
}