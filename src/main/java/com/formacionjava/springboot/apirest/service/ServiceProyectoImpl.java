package com.formacionjava.springboot.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionjava.springboot.apirest.dao.ProyectoDao;
import com.formacionjava.springboot.apirest.entity.Proyecto;

@Service
public class ServiceProyectoImpl implements ServiceProyecto {
	
	@Autowired
	private ProyectoDao proyectoDao;

	@Override
	@Transactional
	public Proyecto save(Proyecto proyecto) {
		return proyectoDao.save(proyecto);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Proyecto> findAll() {
		return (List<Proyecto>) proyectoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Proyecto findById(Long id) {
		return proyectoDao.findById(id).orElse(null);
	}

}
