package com.inventario.microservice.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inventario.microservice.common.service.CommonService;

public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S service;
	
	@PostMapping
	public ResponseEntity<?> crear(E entity){
		return service.save(entity);
	}
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return service.list();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable String id){
		return service.find(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrar(@PathVariable String id){
		return service.delete(id);
	}
}
