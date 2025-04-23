package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.record.UserRegistrationRequestDTO;
import com.example.movieticketbookingsystem.record.UserRegistrationResponseDTO;

public interface UserService {

    UserRegistrationResponseDTO register(UserRegistrationRequestDTO userregistrationrequestDTO);

}

