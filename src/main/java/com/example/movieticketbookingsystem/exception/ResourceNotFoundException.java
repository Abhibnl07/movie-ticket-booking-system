package com.example.movieticketbookingsystem.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException{

    private String message;

    public ResourceNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
