package com.github.igoraguiar.med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ControllerErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity Error404NotFoundException(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity Error400MethodNotAllowedException( MethodArgumentNotValidException ex){
        var errorBody = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errorBody.stream().map(FieldErrorValidation::new));
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity error500SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex){
        var error = ex.getMessage();
        return ResponseEntity.internalServerError().body(error);
    }

    private record FieldErrorValidation(String error, String value){
        FieldErrorValidation(FieldError data){
            this(data.getField(), data.getDefaultMessage());
        }
    }
}
