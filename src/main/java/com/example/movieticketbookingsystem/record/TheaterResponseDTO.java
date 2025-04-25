package com.example.movieticketbookingsystem.record;

public record TheaterResponseDTO(
        String theaterId,
        String name,
        String address,
        String city,
        String landmark
                                  ) {
}
