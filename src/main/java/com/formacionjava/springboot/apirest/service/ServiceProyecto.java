package com.formacionjava.springboot.apirest.service;

import java.util.List;


import com.formacionjava.springboot.apirest.entity.Proyecto;

public interface ServiceProyecto {
	public Proyecto save(Proyecto proyecto);
	public List<Proyecto> findAll();
	public Proyecto findById(Long id);


}
