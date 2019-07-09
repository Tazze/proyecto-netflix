package com.sopra.peliculas.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.peliculas.negocio.GestorPeliculas;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/listPelis")
public class ListPeliculasServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static ApplicationContext context;

    @Override
    public void init() throws ServletException {
        this.context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    }

    public ListPeliculasServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GestorPeliculas gestor = context.getBean("gestorPeliculas", GestorPeliculas.class);

        request.setAttribute("confirm", gestor.listaPelicula().toString());
        getServletContext().getRequestDispatcher("/WEB-INF/jsps/lista.jsp").forward(request, response);
    }

    
}