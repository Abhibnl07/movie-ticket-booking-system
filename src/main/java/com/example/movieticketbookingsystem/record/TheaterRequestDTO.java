package com.example.movieticketbookingsystem.record;

import jakarta.validation.constraints.NotNull;

public record TheaterRequestDTO(
        @NotNull
        String name,
        @NotNull
        String address,
        @NotNull
        String city,
        @NotNull
        String landmark,
        @NotNull
        String createdBy
) {
}
