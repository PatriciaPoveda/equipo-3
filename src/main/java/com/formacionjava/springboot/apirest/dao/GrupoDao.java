package com.formacionjava.springboot.apirest.dao;

import org.springframework.data.repository.CrudRepository;


import com.formacionjava.springboot.apirest.entity.Grupo;

public interface GrupoDao extends CrudRepository<Grupo, Long > {

}