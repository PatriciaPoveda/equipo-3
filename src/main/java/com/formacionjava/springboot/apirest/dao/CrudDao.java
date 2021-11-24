package com.formacionjava.springboot.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionjava.springboot.apirest.empleado.Empleado;

public interface CrudDao extends CrudRepository<Empleado, Long > {

}
