package com.example.movieticketbookingsystem.record;

public record TheaterUpdateRequestDTO(
        String name,
        String address,
        String city,
        String landmark
) {
}
