package com.inventario.microservice.common.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CommonJpaServiceImpl<E, R extends JpaRepository<E, UUID>> implements CommonService<E>{

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
