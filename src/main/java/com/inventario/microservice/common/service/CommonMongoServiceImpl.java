package com.inventario.microservice.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CommonMongoServiceImpl<E, R extends MongoRepository<E, String>> implements CommonService<E>{
	
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
			E entity = dao.findById(id).orElse(null);
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
			dao.deleteById(id);
			return ResponseEntity.status(204).build();
		} catch (Exception e) {
			return error.error500(e);
		}
	}

}
