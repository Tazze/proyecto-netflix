package com.sopra.peliculas.consola;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.sopra.peliculas.dao.PeliculaMapDAO;
import com.sopra.peliculas.modelo.entities.Categoria;
import com.sopra.peliculas.modelo.entities.Pelicula;
import com.sopra.peliculas.negocio.GestorPeliculas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	GestorPeliculas gestor = new GestorPeliculas(new PeliculaMapDAO(new HashMap<Integer, Pelicula>()));
    	
    	
    	System.out.println("-----------------------------");
    	System.out.println("Dando de alta peliculas...");
    	System.out.println("-----------------------------\n");
    	ArrayList<Pelicula> peliculas = new ArrayList<>();
        for(int i = 0; i<10; i++) {
        	Pelicula peli = new Pelicula();
        	peli.setTitulo("Pelicula "+i);
        	peli.setDirector("Director de la pelicula "+i);
        	peli.setSinopsis("Sinopsis de la pelicula "+i);
        	peli.setCategorias(Arrays.asList(Categoria.ACCION));
        	peliculas.add(peli);
        }
        gestor.altaPelicula(peliculas);
        
        for(Pelicula p : gestor.listaPelicula()) {
        	System.out.println(p.toString()+"\n");
        }
        
        
        System.out.println("-----------------------------");
    	System.out.println("Modificando peliculas...");
    	System.out.println("-----------------------------\n");
    	peliculas = new ArrayList<>();
        Iterator<Pelicula> iter = gestor.listaPelicula().iterator();
        for(int i = 0; i<2; i++) {
        	Pelicula p = iter.next();
        	p.setTitulo(p.getTitulo()+" [MODIFICADO]");
        	peliculas.add(p);
        }
        gestor.updatePelicula(peliculas);
        
        for(Pelicula p : gestor.listaPelicula()) {
        	System.out.println(p.toString()+"\n");
        }
        
        
        System.out.println("-----------------------------");
    	System.out.println("Borrando peliculas...");
    	System.out.println("-----------------------------\n");
        iter = gestor.listaPelicula().iterator();
        ArrayList<Integer> peliculasABorrar = new ArrayList<>();
        for(int i = 0; i<2; i++) {
        	peliculasABorrar.add(iter.next().getIdentificador());
        }
        gestor.deletePelicula(peliculasABorrar);
        
        for(Pelicula p : gestor.listaPelicula()) {
        	System.out.println(p.toString()+"\n");
        }
        
    }
}
