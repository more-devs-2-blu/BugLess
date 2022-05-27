package com.BugLess.controller.exceptions;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.BugLess.service.exceptions.InvalidCpfException;
import com.BugLess.service.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Informação não encontrada!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(LocalDate.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(InvalidCpfException.class)
	public ResponseEntity<StandardError> dataBase(InvalidCpfException e, HttpServletRequest request){
		String error = "Número do registro de contribuinte individual brasileiro (CPF) inválido.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(LocalDate.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
