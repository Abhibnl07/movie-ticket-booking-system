package com.example.movieticketbookingsystem.exception;

import lombok.Getter;

@Getter
public class ConflictException extends RuntimeException{

    private String message;

    public ConflictException(String message) {
        super(message);
        this.message = message;
    }
}
