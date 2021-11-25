package com.formacionjava.springboot.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.formacionjava.springboot.apirest.dao.ProyectoDao;
import com.formacionjava.springboot.apirest.entity.Proyecto;


public class ServiceProyectoImpl implements ServiceProyecto {
	
	@Autowired
	private ProyectoDao proyectoDao;

	@Override
	public Proyecto save(Proyecto proyecto) {
		return proyectoDao.save(proyecto);
	}

	@Override
	public List<Proyecto> findAll() {
		// TODO Auto-generated method stub
		return (List<Proyecto>) proyectoDao.findAll();
	}

	@Override
	public Proyecto findById(Long id) {
		return proyectoDao.findById(id).orElse(null);
	}

}
