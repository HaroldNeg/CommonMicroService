package com.inventario.microservice.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CommonReacticeMongoServiceImpl<E, R extends ReactiveMongoRepository<E, String>> implements CommonService<E>{
	
	@Autowired
	protected R dao;

	@Override
	public ResponseEntity<?> save(RequestEntity<?> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
