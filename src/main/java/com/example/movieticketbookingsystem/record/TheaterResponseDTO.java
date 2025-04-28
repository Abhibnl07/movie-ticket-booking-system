package com.example.movieticketbookingsystem.record;

import jakarta.validation.constraints.NotNull;

public record TheaterResponseDTO(
        @NotNull
        String name,
        @NotNull
        String address,
        @NotNull
        String city,
        @NotNull
        String landmark
                                  ) {
}
