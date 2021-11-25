package com.formacionjava.springboot.apirest.service;

import java.util.List;

import com.formacionjava.springboot.apirest.entity.Empleado;


public interface ServiceEmpleado {
	public List<Empleado> findAll();
	public Empleado findById(Long id);
//Implementar login
//Guardar id de grupo
	
}
