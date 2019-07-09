package com.sopra.peliculas;

import java.util.concurrent.ConcurrentHashMap;

import com.sopra.peliculas.dao.IPeliculaDAO;
import com.sopra.peliculas.dao.PeliculaMapDAO;
import com.sopra.peliculas.modelo.entities.Pelicula;

public class Factory{
    private static IPeliculaDAO dao;

    public static IPeliculaDAO getDAO(){
        if(dao == null){
            dao = new PeliculaMapDAO(new ConcurrentHashMap<Integer, Pelicula>());
        }
        return dao;
    }
}