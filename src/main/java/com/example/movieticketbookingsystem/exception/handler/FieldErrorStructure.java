package com.example.movieticketbookingsystem.exception.handler;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FieldErrorStructure <T>{
    private int statusCode;

    @JsonProperty("error_message")
    private String errorMessage;

    T data;
}
