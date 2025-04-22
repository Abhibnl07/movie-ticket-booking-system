package com.example.movieticketbookingsystem.utility;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ResponseStructure<T> {

    private int statusCode;
    private String message;
    private T data;

}
