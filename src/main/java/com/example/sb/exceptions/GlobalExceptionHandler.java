package com.example.sb.exceptions;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException e) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", Instant.now());
		body.put("status", HttpStatus.NOT_FOUND.value());
		body.put("error", "Resource not found.");
		body.put("message", e.getMessage());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleGenericException(ResourceNotFoundException e) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", Instant.now());
		body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		body.put("error", "Internal server error");
		body.put("message", e.getMessage());
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
