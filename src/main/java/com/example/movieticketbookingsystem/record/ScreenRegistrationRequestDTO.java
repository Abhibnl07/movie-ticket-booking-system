package com.example.movieticketbookingsystem.record;

import com.example.movieticketbookingsystem.enums.ScreenType;

public record ScreenRegistrationRequestDTO(

        ScreenType screenType,
        Integer capacity,
        Integer noOfRows
) {
}
