package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.record.TheaterRequestDTO;
import com.example.movieticketbookingsystem.record.TheaterResponseDTO;
import jakarta.validation.Valid;

public interface TheaterService {
    TheaterResponseDTO addTheater(String email, TheaterRequestDTO theaterRequestDTO);
}
