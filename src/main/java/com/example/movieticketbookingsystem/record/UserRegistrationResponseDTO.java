package com.example.movieticketbookingsystem.record;

import com.example.movieticketbookingsystem.enums.UserRole;

public record UserRegistrationResponseDTO(
        String userId,
        String username,
        String email,
        UserRole role

        ) {
}
