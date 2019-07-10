package com.sopra.peliculas.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sopra.peliculas.modelo.entities.Pelicula;
import com.sopra.peliculas.negocio.GestorPeliculas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("request")
public class ControllerPeliculas{

    @Autowired
    private GestorPeliculas gestor; 
    @Autowired
    private Pelicula pelicula;

    @RequestMapping("movieForm")
    public ModelAndView formularioPelicula(HttpServletRequest request){
        return new ModelAndView("altaPelicula");
    }

    @RequestMapping("insertMovie")
    public ModelAndView insertar(@RequestParam("titulo") String titulo, @RequestParam("director") String director, @RequestParam("sinopsis") String sinopsis,  HttpServletRequest request){

        pelicula.setDirector(director);
        pelicula.setSinopsis(sinopsis);
        pelicula.setTitulo(titulo);

        List<Pelicula> peliculas = new ArrayList<>();

        peliculas.add(pelicula);

        gestor.altaPelicula(peliculas);

        ModelAndView modelAndView = new ModelAndView("mostrarPelicula");
        modelAndView.addObject("pelicula", this.pelicula);
        return modelAndView;
    }

    @RequestMapping("listMovies")
    public ModelAndView listar(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("listarPeliculas");
        modelAndView.addObject("lista", gestor.listaPelicula());
        return modelAndView;
    }

}