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
import com.formacionjava.springboot.apirest.entity.Proyecto;
import com.formacionjava.springboot.apirest.service.ServiceProyecto;

@RestController
@RequestMapping("/team3")
public class ProyectoRestController {

	@Autowired
	private ServiceProyecto serviceProyecto;
	//MOSTRAR PROYECTOS
	@GetMapping("/proyectos")
	public List<Proyecto> index() {
		return serviceProyecto.findAll();
	}
	
	//CREAR PROYECTO
		@PostMapping("/proyectos")
		public ResponseEntity<?> create(@RequestBody Proyecto proyecto) {
			Proyecto proyectoNew = null;
			Map<String, Object> response = new HashMap<>();

			try {
				proyecto = serviceProyecto.save(proyecto);
			} catch (DataAccessException e) {
				response.put("mensaje", "Error al realizar insert en base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			response.put("mensaje", "El proyecto ha sido creado con exito");
			response.put("proyecto", proyectoNew);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
		//ACTUALIZAR PROYECTO
		
		@PutMapping("/proyectos/{id}")
		public ResponseEntity<?> update(@RequestBody Proyecto proyecto, @PathVariable Long id) {
			Proyecto proyectoActual = serviceProyecto.findById(id);
			Proyecto proyectoUpdate = null;
			Map<String, Object> response = new HashMap<>();

			if (proyecto == null) {
				response.put("mensaje", "Error: No se pudo editar el proyecto con ID: "
						.concat(id.toString().concat(" no existe la ID en la base de datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

			try {
				proyectoActual.setNombreProyecto(proyecto.getNombreProyecto());
				
				
				proyectoUpdate = serviceProyecto.save(proyectoActual);
			} catch (DataAccessException e) {
				response.put("mensaje", "Error al actualizar el proyecto en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put("mensaje", "El proyecto ha sido actualizado con exito");
			response.put("proyecto", proyectoUpdate);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
}
