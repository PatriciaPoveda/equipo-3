package com.formacionjava.springboot.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionjava.springboot.apirest.entity.Grupo;
import com.formacionjava.springboot.apirest.service.ServiceGrupo;

@RestController
@RequestMapping("/team3")
public class GrupoRestController {
	@Autowired
	private ServiceGrupo serviceGrupo;
	
	//MOSTRAR TODOS LOS GRUPOS
	@GetMapping("/grupos")
	public List<Grupo> index() {
		return serviceGrupo.findAll();
	}
	//CREAR GRUPO
	@PostMapping("/grupos")
	public ResponseEntity<?> create(@RequestBody Grupo grupo) {
		Grupo grupoNew = null;
		Map<String, Object> response = new HashMap<>();

		try {
			grupo = serviceGrupo.save(grupo);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar insert en base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El grupo ha sido creado con exito");
		response.put("grupo", grupoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//ACTUALIZAR GRUPOS
	
	@PutMapping("/grupos/{id}")
	public ResponseEntity<?> update(@RequestBody Grupo grupo, @PathVariable Long id) {
		Grupo grupoActual = serviceGrupo.findById(id);
		Grupo grupoUpdate = null;
		Map<String, Object> response = new HashMap<>();

		if (grupo == null) {
			response.put("mensaje", "Error: No se pudo editar el grupo con ID: "
					.concat(id.toString().concat(" no existe la ID en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			grupoActual.setNombreGrupo(grupo.getNombreGrupo());
			
			
			grupoUpdate = serviceGrupo.save(grupoActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el grupo en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El grupo ha sido actualizado con exito");
		response.put("grupo", grupoUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
