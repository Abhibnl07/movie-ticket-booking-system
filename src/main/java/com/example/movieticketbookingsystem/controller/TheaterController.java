package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.record.TheaterRequestDTO;
import com.example.movieticketbookingsystem.record.TheaterResponseDTO;
import com.example.movieticketbookingsystem.record.UserRegistrationRequestDTO;
import com.example.movieticketbookingsystem.record.UserRegistrationResponseDTO;
import com.example.movieticketbookingsystem.service.TheaterService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    @PostMapping("/add")
    public ResponseEntity<ResponseStructure<TheaterResponseDTO>> addTheater(@RequestParam String email, @RequestBody TheaterRequestDTO theaterRequestDTO){

        TheaterResponseDTO theater= theaterService.addTheater(email,theaterRequestDTO);

        ResponseStructure<TheaterResponseDTO> rs=new ResponseStructure<TheaterResponseDTO>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("registered  successfully");
        rs.setData(theater);

        return new ResponseEntity<ResponseStructure<TheaterResponseDTO>>(rs,HttpStatus.CREATED);
    }
}
