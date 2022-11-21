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

	@GetMapping("/{id}")
	public ResponseEntity<Curso> buscarPorId(@PathVariable() Long id){
		return cursoRepository.findById(id)
				.map(curso -> ResponseEntity.ok().body(curso))	//Si encuentra el curso
				.orElse(ResponseEntity.notFound().build());		//Sino encuentra nada
	}



	@PutMapping("/{id}")
	public ResponseEntity<Curso> actualizar(@PathVariable Long id, @RequestBody Curso curso) {

		return cursoRepository.findById(id)
				.map(cursoFound -> {
					cursoFound.setNombre(curso.getNombre());
					cursoFound.setCategoria(curso.getCategoria());
					Curso cursoActualizado = cursoRepository.save(cursoFound);

					return ResponseEntity.ok().body(cursoActualizado);
				})
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		return cursoRepository.findById(id)
				.map(regEncontrado -> {
					cursoRepository.deleteById(id);
					return ResponseEntity.noContent().<Void>build(); //Se castea de noContent a Void para que el response no reclame
				})
				.orElse(ResponseEntity.notFound().build());
	}
}

