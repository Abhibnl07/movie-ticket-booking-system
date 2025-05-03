package com.example.movieticketbookingsystem.record;

import com.example.movieticketbookingsystem.enums.ScreenType;

import java.util.List;

public record ScreenResponseDTO(
        ScreenType screenType,
        Integer capacity,
        Integer noOfRows,
        List<SeatResponseDTO> seats
) {
}
