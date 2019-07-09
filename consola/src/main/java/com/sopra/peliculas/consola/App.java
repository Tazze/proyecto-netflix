package com.sopra.peliculas.consola;

import java.util.List;
import java.util.Iterator;

import com.sopra.peliculas.config.SpringConfig;
import com.sopra.peliculas.modelo.entities.Pelicula;
import com.sopra.peliculas.negocio.GestorPeliculas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{

    private static ApplicationContext context;
	
	static {
		context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
	}

    public static void main( String[] args )
    {	
        GestorPeliculas gestor = context.getBean("gestorPeliculas", GestorPeliculas.class);
        
        //ALTA

        printMessage("Dando de alta peliculas...");

        List<Pelicula> peliculas = context.getBean("listaPeliculas", List.class);  

        for(int i = 0; i<10; i++) {
        	Pelicula peli = context.getBean("pelicula", Pelicula.class);
        	peliculas.add(peli);
        }
        gestor.altaPelicula(peliculas);
        
        listarPeliculas(gestor);
        
        //MODIFICACION

        printMessage("Modificando peliculas...");
        peliculas = context.getBean("listaPeliculas", List.class);  
        Iterator<Pelicula> iter = gestor.listaPelicula().iterator();
        for(int i = 0; i<2; i++) {
        	Pelicula p = iter.next();
        	p.setTitulo(p.getTitulo()+" [MODIFICADO]");
        	peliculas.add(p);
        }
        gestor.updatePelicula(peliculas);
        
        listarPeliculas(gestor);
        
        
        //BORRADO

        printMessage("Borrando peliculas...");

        iter = gestor.listaPelicula().iterator();
        List<Integer> peliculasABorrar = context.getBean("listaPeliculas", List.class); 
        for(int i = 0; i<2; i++) {
        	peliculasABorrar.add(iter.next().getIdentificador());
        }
        gestor.deletePelicula(peliculasABorrar);
        
        listarPeliculas(gestor);
        
    }

    private static void printMessage(String str){
        System.out.println("-----------------------------");
    	System.out.println(str);
        System.out.println("-----------------------------\n");
    }

    private static void listarPeliculas(GestorPeliculas gestor){
        System.out.println("numero de peliculas:" + gestor.listaPelicula().size() + "\n");
        for(Pelicula p : gestor.listaPelicula()) {
        	System.out.println(p.toString()+"\n");
        }
    }
}
