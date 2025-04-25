package com.example.movieticketbookingsystem.record;

public record TheaterRequestDTO(
        String name,
        String address,
        String city,
        String landmark,
        String createdBy
) {
}
