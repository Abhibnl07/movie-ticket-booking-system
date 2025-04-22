package com.example.movieticketbookingsystem.responsebuilder;

import com.example.movieticketbookingsystem.utility.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestResponseBuilder {

    public <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .statusCode(status.value())
                .message(message)
                .data(data)
                .build();
        ;

        return  ResponseEntity.status(status).body(structure);
    }
}
