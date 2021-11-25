package com.formacionjava.springboot.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionjava.springboot.apirest.dao.EmpleadoDao;
import com.formacionjava.springboot.apirest.entity.Empleado;


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;



@Service
public class ServiceEmpleadoImpl implements ServiceEmpleado {

	@Autowired
	private EmpleadoDao empleadoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Empleado>findAll(){
		return (List<Empleado>) empleadoDao.findAll(); 
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Long id) {
		return empleadoDao.findById(id).orElse(null);
	}
}
