package com.formacionjava.springboot.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionjava.springboot.apirest.entity.Proyecto;

public interface ProyectoDao extends CrudRepository<Proyecto, Long > {

}
