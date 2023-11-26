package com.almeida.springmongodb.resources.exceptions;

import com.almeida.springmongodb.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {
        StandardError error = new StandardError(new Date(), NOT_FOUND.value(), "Not found error",exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(NOT_FOUND).body(error);
    }

}
