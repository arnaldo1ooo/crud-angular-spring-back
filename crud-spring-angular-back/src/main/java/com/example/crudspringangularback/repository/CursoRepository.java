package com.example.crudspringangularback.repository;

import org.springframework.stereotype.Repository;

import com.example.crudspringangularback.model.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	
}
