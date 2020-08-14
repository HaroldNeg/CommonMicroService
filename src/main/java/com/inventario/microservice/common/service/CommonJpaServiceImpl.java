package com.inventario.microservice.common.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CommonJpaServiceImpl<E, R extends JpaRepository<E, UUID>> implements CommonService<E>{

	@Autowired
	protected R dao; 
	
	@Autowired
	protected ErrorServiceImpl error;
	
	@Override
	public ResponseEntity<?> save(E entity) {
		try {
			dao.save(entity);
			return ResponseEntity.status(201).build();
		} catch (Exception e) {
			return error.error500(e);
		}
	}

	@Override
	public ResponseEntity<?> list() {
		try {
			List<E> list = dao.findAll();
			if (list.isEmpty()) {
				return error.error404();
			}
			return ResponseEntity.status(200).body(list);
		} catch (Exception e) {
			return error.error500(e);
		}
	}

	@Override
	public ResponseEntity<?> find(String id) {
		try {
			E entity = dao.findById(UUID.fromString(id)).orElse(null);
			if (entity == null) {
				return error.error404();
			} else {
				return ResponseEntity.status(200).body(entity);
			}
		} catch (Exception e) {
			return error.error500(e);
		}
	}

	@Override
	public ResponseEntity<?> delete(String id) {
		try {
			dao.deleteById(UUID.fromString(id));
			return ResponseEntity.status(204).build();
		} catch (Exception e) {
			return error.error500(e);
		}
	}

}
