package com.example.crudspringangularback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("_id")	//Cuando genere de Objeto a Json al enviar al front, enviara con este nombre
	private Long id;
	
	@Column(name="cur_nombre", length = 200, nullable = false)
	private String nombre;
	
	@Column(name="cur_categoria", length = 200, nullable = false)
	private String categoria;
}
