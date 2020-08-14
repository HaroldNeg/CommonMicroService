package com.inventario.microservice.common.service;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

public interface CommonService<E> {

	public abstract ResponseEntity<?> save(RequestEntity<?> entity);

	public abstract ResponseEntity<?> list();
	
	public abstract ResponseEntity<?> find(String id);
	
	public abstract ResponseEntity<?> delete(String id);
}
