package com.example.movieticketbookingsystem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

public class UserNotRegistered extends RuntimeException{

    private String message;

    public UserNotRegistered(String message) {
        super(message);
        this.message = message;
    }
}
