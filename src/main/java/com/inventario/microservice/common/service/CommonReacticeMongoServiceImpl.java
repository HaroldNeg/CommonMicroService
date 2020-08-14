package com.inventario.microservice.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Transactional
public class CommonReacticeMongoServiceImpl<E, R extends ReactiveMongoRepository<E, String>> implements CommonService<E>{
	
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
			Flux<E> list = dao.findAll();
			return ResponseEntity.status(200).body(list);
		} catch (Exception e) {
			return error.error500(e);
		}
	}

	@Override
	public ResponseEntity<?> find(String id) {
		try {
			Mono<E> entity = dao.findById(id);
			return ResponseEntity.status(200).body(entity);
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
