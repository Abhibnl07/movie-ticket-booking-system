package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.record.ScreenRegistrationRequestDTO;
import com.example.movieticketbookingsystem.record.ScreenResponseDTO;
import com.example.movieticketbookingsystem.record.TheaterRequestDTO;
import com.example.movieticketbookingsystem.record.TheaterResponseDTO;
import com.example.movieticketbookingsystem.service.ScreenService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class ScreenController {

    private final ScreenService screenService;


    @PostMapping("/screen")
    public ResponseEntity<ResponseStructure<ScreenResponseDTO>> registerScreen(@RequestParam String theaterId, @RequestBody ScreenRegistrationRequestDTO screenRegistrationRequestDTO){

        ScreenResponseDTO theater= screenService.registerScreen(theaterId,screenRegistrationRequestDTO);

        ResponseStructure<ScreenResponseDTO> rs=new ResponseStructure<ScreenResponseDTO>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("registered  successfully");
        rs.setData(theater);

        return new ResponseEntity<ResponseStructure<ScreenResponseDTO>>(rs,HttpStatus.CREATED);
    }


    @GetMapping("/display")
    public ResponseEntity<ResponseStructure<ScreenResponseDTO>> displayScreen(@RequestParam String screenId){

        ScreenResponseDTO theater= screenService.displayScreen(screenId);

        ResponseStructure<ScreenResponseDTO> rs=new ResponseStructure<ScreenResponseDTO>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("displayed  successfully");
        rs.setData(theater);

        return new ResponseEntity<ResponseStructure<ScreenResponseDTO>>(rs,HttpStatus.CREATED);
    }
}
