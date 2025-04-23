package com.example.movieticketbookingsystem.exception;

import lombok.Getter;

@Getter
public class UserNotFoundByEmail extends RuntimeException{

    private String message;

    public UserNotFoundByEmail(String message) {
        super(message);
        this.message = message;
    }
}
