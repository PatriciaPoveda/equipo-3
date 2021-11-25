package com.formacionjava.springboot.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionjava.springboot.apirest.entity.Empleado;

public interface EmpleadoDao extends CrudRepository<Empleado, Long > {

}
