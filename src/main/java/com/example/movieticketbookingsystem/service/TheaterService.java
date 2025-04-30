package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.record.TheaterRequestDTO;
import com.example.movieticketbookingsystem.record.TheaterResponseDTO;
import com.example.movieticketbookingsystem.record.TheaterUpdateRequestDTO;
import com.example.movieticketbookingsystem.record.TheaterUpdateResponseDTO;
import jakarta.validation.Valid;

public interface TheaterService {
    TheaterResponseDTO addTheater(String email, TheaterRequestDTO theaterRequestDTO);
    TheaterResponseDTO findTheaterById(String theaterId);

    TheaterUpdateResponseDTO updateTheaterById(String theaterId, TheaterUpdateRequestDTO theaterUpdateRequestDTO);
}
