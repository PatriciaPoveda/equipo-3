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
@Table(name = "empleados")
public class Empleado implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "ID del empleado", name = "id")
	private long id;
	
	@ApiModelProperty(notes = "Nombre del empleado", name = "nombre", required = true, example = "Lucía")
	@Column(nullable = false)
	private String nombre;
	
	@ApiModelProperty(notes = "apellidos del empleado", name = "apellidos", required = true, example = "Perez")
	@Column(nullable = false)
	private String apellidos;
	
	@ApiModelProperty(notes = "Correo electrónico del empleado", name = "email", required = true, example = "lucía@capgemini.com")
	@Column(nullable = false, unique = true)
	private String email;
	
	@ApiModelProperty(notes = "Teléfono de contacto", name = "telefono", example = "666339922")
	@Column(unique = true)
	private String telefono;
	
	@ApiModelProperty(notes = "área de departamento", name = "departamento", example = "Backend")
	@Column(name = "area_dep")
	private String area_dep;
	
	@ApiModelProperty(notes = "cargo que tiene", name = "cargo", example = "junior")
	@Column(name = "cargo")
	private String cargo;
	
	@ApiModelProperty(notes = "Está trabajando", example = "true", required = true, position = 1)
	@Column(name = "activado")
	private Boolean activado;
	
	//GETTERS Y SETTERS
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getArea_dep() {
		return area_dep;
	}
	public void setArea_dep(String area_dep) {
		this.area_dep = area_dep;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Boolean getActivado() {
		return activado;
	}
	public void setActivado(Boolean activado) {
		this.activado = activado;
	}

	
	private static final long serialVersionUID = 1L;
}
