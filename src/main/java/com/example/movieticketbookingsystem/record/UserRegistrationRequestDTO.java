package com.example.movieticketbookingsystem.record;

import com.example.movieticketbookingsystem.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


public record UserRegistrationRequestDTO(
       String username,
       String email,
       String phoneNumber,
       String password,
       UserRole role,
       LocalDate dateOfBirth

        ) {
}
