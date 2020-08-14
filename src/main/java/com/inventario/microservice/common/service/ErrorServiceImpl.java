package com.inventario.microservice.common.service;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.inventario.microservice.common.entity.ErrorEntity;

@Component
public class ErrorServiceImpl {

	public ResponseEntity<ErrorEntity> error400(Exception e){
		return ResponseEntity.status(400).body(error("Error en la petición", 400, e));
	}
	
	public ResponseEntity<ErrorEntity> error404(){
		return ResponseEntity.status(404).body(error("No se encontró registro(s)", 404, null));
	}
	
	public ResponseEntity<ErrorEntity> error500(Exception e){
		return ResponseEntity.status(500).body(error("Error en el servidor", 500, e));
	}
	
	private ErrorEntity error(String error, int status, Exception e) {
		String message = "";
		if (e != null) {
			message = e.getLocalizedMessage()+"\n"+e.getMessage()+"\n"+e.getCause();
		} 
		return ErrorEntity.builder()
				.error(error)
				.status(status)
				.message(message)
				.datetime(LocalDateTime.now())
				.build();
	}
}
