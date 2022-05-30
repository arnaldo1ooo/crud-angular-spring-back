package com.example.crudspringangularback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudspringangularback.model.Curso;
import com.example.crudspringangularback.repository.CursoRepository;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	 
	
	@GetMapping
	public List<Curso> listarAllCursos() {
		return cursoRepository.findAll();
	}
	
	
}
