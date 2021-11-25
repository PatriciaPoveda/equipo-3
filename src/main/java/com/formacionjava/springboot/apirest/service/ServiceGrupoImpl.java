package com.formacionjava.springboot.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionjava.springboot.apirest.dao.GrupoDao;
import com.formacionjava.springboot.apirest.entity.Grupo;

@Service
public class ServiceGrupoImpl implements ServiceGrupo {
	
	@Autowired
	private GrupoDao grupoDao;

	@Override
	public List<Grupo> findAll() {
		return (List<Grupo>) grupoDao.findAll();
	}

	@Override
	public Grupo save(Grupo grupo) {
		return grupoDao.save(grupo);
	}

	@Override
	public Grupo findById(Long id) {
		return grupoDao.findById(id).orElse(null);
	}
}
