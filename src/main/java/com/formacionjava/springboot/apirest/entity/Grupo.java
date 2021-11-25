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
@Table(name = "grupos")
public class Grupo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "ID del grupo", name = "id")
	private long id;
	
	@ApiModelProperty(notes = "Está trabajando", example = "true", required = true, position = 2)
	@Column(nullable = false)
	private String nombreGrupo;
	
	//GETTERS Y SETTERS
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombreGrupo() {
		return nombreGrupo;
	}


	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}


	private static final long serialVersionUID = 1L;
}
