package com.desafio.listadetarefas.exception;

import javax.servlet.http.HttpServlet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javassist.tools.rmi.ObjectNotFoundException;


@ResponseStatus(HttpStatus.NOT_FOUND)
@ControllerAdvice
public class RecursoNotFound extends RuntimeException {
 private static final long serialVersionUID = 1L;

 @ExceptionHandler(ObjectNotFoundException.class)
 public ResponseEntity<ErroPadrao> 
 objectNotFound(ObjectNotFoundException e, HttpServlet request) {
   ErroPadrao ep = new ErroPadrao(e.getMessage(), HttpStatus.NOT_FOUND.value() , System.currentTimeMillis());
   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ep);
 }

 public RecursoNotFound() {
  super();
 }

 public RecursoNotFound(String message) {
  super(message);
}

public RecursoNotFound(String message, Throwable cause) {
  super(message, cause);
}



}