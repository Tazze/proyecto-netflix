package com.sopra.peliculas.restjpa.config;

import java.util.Arrays;

import com.sopra.peliculas.restjpa.model.MovieRepository;
import com.sopra.peliculas.restjpa.model.entities.Pelicula;
import com.sopra.peliculas.modelo.entities.Categoria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {


	@Bean
	public CommandLineRunner iniciarBaseDeDatos(MovieRepository repositorio) {
		return args -> {
			repositorio.save(new Pelicula("Zootopia", "Byron Howard", "In a city of anthropomorphic animals, a rookie bunny cop and a cynical con artist fox must work together to uncover a conspiracy.", Arrays.asList(new Categoria[]{Categoria.ACCION, Categoria.COMEDIA})));
		};
	}
}