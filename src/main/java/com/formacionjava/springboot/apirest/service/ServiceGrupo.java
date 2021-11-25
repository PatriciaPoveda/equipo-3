package com.formacionjava.springboot.apirest.service;

import java.util.List;

import com.formacionjava.springboot.apirest.entity.Grupo;

public interface ServiceGrupo {
	public List<Grupo> findAll();
	public Grupo save(Grupo grupo);
	//guardar id proyecto
}
