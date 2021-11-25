package com.formacionjava.springboot.apirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "proyectos")
public class Proyecto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "ID del proyecto", name = "id")
	private long id;
	
	@ApiModelProperty(notes = "Está trabajando", example = "true", required = true, position = 3)
	@Column(nullable = false)
	private String nombreProyecto;
	
	
	//GETTERS Y SETTERS
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNombreProyecto() {
		return nombreProyecto;
	}



	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}



	private static final long serialVersionUID = 1L;
}
