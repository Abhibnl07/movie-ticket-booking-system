package com.example.movieticketbookingsystem.record;

import com.example.movieticketbookingsystem.enums.UserRole;
import jakarta.validation.constraints.*;

import java.time.LocalDate;


public record UserRegistrationRequestDTO(
       @NotNull(message = "user name cannot be null")
       @NotBlank(message = "user name cannot be blank")
       String username,
       @NotNull(message = "user email cannot be null")
       String email,
       @NotNull(message = "user phone number cannot be null")
       String phoneNumber,
       @NotNull(message = "user password cannot be null")
       String password,
       @NotNull(message = "user role cannot be null")
       UserRole role,
       @NotNull(message = "user dob cannot be null")
       LocalDate dateOfBirth

        ) {
}
