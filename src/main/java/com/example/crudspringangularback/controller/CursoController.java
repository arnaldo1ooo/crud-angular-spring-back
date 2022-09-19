package com.example.crudspringangularback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.crudspringangularback.model.Curso;
import com.example.crudspringangularback.repository.CursoRepository;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	 
	
	@GetMapping
	public List<Curso> listarTodos() {
		return cursoRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED) //Para que devuelva codigo 201 (Objeto creado)
	public Curso crear(@RequestBody Curso curso){
		return cursoRepository.save(curso);
	}
}
