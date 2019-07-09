package com.sopra.peliculas.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.peliculas.modelo.entities.Pelicula;
import com.sopra.peliculas.negocio.GestorPeliculas;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/insertPeli")
public class InsertPeliculaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static ApplicationContext context;

    @Override
    public void init() throws ServletException {
        this.context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    }

    public InsertPeliculaServlet() {
        super();
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(request.getParameter("titulo"));
        pelicula.setDirector(request.getParameter("director"));
        pelicula.setSinopsis(request.getParameter("sinopsis"));

        GestorPeliculas gestor = context.getBean("gestorPeliculas", GestorPeliculas.class);

        List<Pelicula> peliculas = context.getBean("listaPeliculas", List.class);

        peliculas.add(pelicula);

        gestor.altaPelicula(peliculas);

        request.setAttribute("confirm", "Pelicula dada de alta! " + pelicula.toString());
        getServletContext().getRequestDispatcher("/WEB-INF/jsps/alta.jsp").forward(request, response);
    }

    
}