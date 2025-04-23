package com.example.movieticketbookingsystem.record;

public record UserUpdateRequestDTO(
        String username,
        String phoneNumber
) {
}
