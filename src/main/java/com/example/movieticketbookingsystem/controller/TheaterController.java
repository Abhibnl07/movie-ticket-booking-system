package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.record.*;
import com.example.movieticketbookingsystem.service.TheaterService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    @PreAuthorize("hasAuthority('THEATER_OWNER')")
    @PostMapping("/add")
    public ResponseEntity<ResponseStructure<TheaterResponseDTO>> addTheater(@RequestParam String email, @RequestBody TheaterRequestDTO theaterRequestDTO){

        TheaterResponseDTO theater= theaterService.addTheater(email,theaterRequestDTO);

        ResponseStructure<TheaterResponseDTO> rs=new ResponseStructure<TheaterResponseDTO>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("registered  successfully");
        rs.setData(theater);

        return new ResponseEntity<ResponseStructure<TheaterResponseDTO>>(rs,HttpStatus.CREATED);
    }

    @GetMapping("/findbyid")
    public ResponseEntity<ResponseStructure<TheaterResponseDTO>> findTheaterById(String theaterId){

        TheaterResponseDTO theater= theaterService.findTheaterById(theaterId);

        ResponseStructure<TheaterResponseDTO> rs=new ResponseStructure<TheaterResponseDTO>();
        rs.setStatusCode(HttpStatus.FOUND.value());
        rs.setMessage("registered  successfully");
        rs.setData(theater);

        return new ResponseEntity<ResponseStructure<TheaterResponseDTO>>(rs,HttpStatus.FOUND);
    }

 feature/security
    @PutMapping("/theaters/{id}")
    public ResponseEntity<ResponseStructure<TheaterUpdateResponseDTO>> updateTheaterById(@RequestParam String theaterId,@RequestBody TheaterUpdateRequestDTO theaterUpdateRequestDTO){




        TheaterUpdateResponseDTO theater= theaterService.updateTheaterById(theaterId,theaterUpdateRequestDTO);

        ResponseStructure<TheaterUpdateResponseDTO> rs=new ResponseStructure<TheaterUpdateResponseDTO>();
        rs.setStatusCode(HttpStatus.FOUND.value());
        rs.setMessage("updated  successfully");
        rs.setData(theater);

        return new ResponseEntity<ResponseStructure<TheaterUpdateResponseDTO>>(rs,HttpStatus.FOUND);
    }
}
