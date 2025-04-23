package com.example.movieticketbookingsystem.exception.handler;

import com.example.movieticketbookingsystem.exception.UserNotFoundByEmail;
import com.example.movieticketbookingsystem.exception.UserNotRegistered;
import com.example.movieticketbookingsystem.utility.ErrorStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleUserNotRegistered(UserNotRegistered ex){

       ErrorStructure<String> errorStructure=ErrorStructure.<String>builder()
               .status(HttpStatus.NOT_FOUND.value())
               .type("user exist")
               .message(ex.getMessage()).build();

       return new ResponseEntity<>(errorStructure,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> UserNotFound(UserNotFoundByEmail ex){

        ErrorStructure<String> errorStructure=ErrorStructure.<String>builder()
                .status(HttpStatus.NOT_FOUND.value())
                .type("user exist")
                .message(ex.getMessage()).build();

        return new ResponseEntity<>(errorStructure,HttpStatus.NOT_FOUND);

    }
}
