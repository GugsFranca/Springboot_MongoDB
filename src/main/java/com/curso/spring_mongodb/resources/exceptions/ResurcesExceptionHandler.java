package com.curso.spring_mongodb.resources.exceptions;

import com.curso.spring_mongodb.service.exception.ObjectNotFindException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResurcesExceptionHandler {

    @ExceptionHandler(ObjectNotFindException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFindException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI() );
        return ResponseEntity.status(status).body(error);
    }
}
