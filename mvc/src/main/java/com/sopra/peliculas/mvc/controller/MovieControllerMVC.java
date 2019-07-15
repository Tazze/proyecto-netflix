package com.sopra.peliculas.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import com.sopra.peliculas.modelo.entities.Categoria;
import com.sopra.peliculas.modelo.entities.Pelicula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MovieControllerMVC{

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("movie", new Pelicula());
        System.out.println("home");
        return "movie";
    }

    @RequestMapping("/list")
    public String movieList(Model model){
        String dataURL = "http://proyecto-netflix-restjpa/repositorio";
        ResponseEntity<List> response = restTemplate.exchange(dataURL, HttpMethod.GET, null, List.class);
        List movies = response.getBody();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @RequestMapping("/new")
    public String newMovie(@RequestParam("titulo") String titulo, @RequestParam("director") String director, @RequestParam("sinopsis") String sinopsis,  Model model){
        String dataURL = "http://proyecto-netflix-restjpa/repositorio";
        Pelicula movie = new Pelicula(titulo, director, sinopsis, new ArrayList<Categoria>());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Pelicula> queryEntity = new HttpEntity<Pelicula>(movie, headers);
        ResponseEntity<Pelicula> responseEntity = restTemplate.exchange(dataURL, HttpMethod.POST, queryEntity, Pelicula.class);
        Pelicula insertedMovie = responseEntity.getBody();
        model.addAttribute("movie", insertedMovie);
        return "movie";
    }


}