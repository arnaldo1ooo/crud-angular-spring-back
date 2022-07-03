package com.example.crudspringangularback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.crudspringangularback.model.Curso;
import com.example.crudspringangularback.repository.CursoRepository;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CrudSpringAngularBackApplication {
	@Autowired
	private CursoRepository cursoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CrudSpringAngularBackApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initDataBase() {
		return args -> {
			cursoRepository.deleteAll();
			
			Curso curso = new Curso();
			curso.setNombre("Angular con Spring");
			curso.setCategoria("front-end");
			
			cursoRepository.save(curso);
		};
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

}
