package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.record.ScreenRegistrationRequestDTO;
import com.example.movieticketbookingsystem.record.ScreenResponseDTO;

public interface ScreenService {
    ScreenResponseDTO registerScreen(String theaterId, ScreenRegistrationRequestDTO screenRegistrationRequestDTO);

    ScreenResponseDTO displayScreen(String screenId);
}
