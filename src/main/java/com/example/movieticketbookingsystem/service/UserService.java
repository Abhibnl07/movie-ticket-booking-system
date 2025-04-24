package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.record.UserRegistrationRequestDTO;
import com.example.movieticketbookingsystem.record.UserRegistrationResponseDTO;
import com.example.movieticketbookingsystem.record.UserUpdateRequestDTO;

public interface UserService {

    UserRegistrationResponseDTO register(UserRegistrationRequestDTO userregistrationrequestDTO);

    String userDetailsUpdate(String email,UserUpdateRequestDTO userupdaterequestDTO);

    void userSoftDelete(String email);
}

