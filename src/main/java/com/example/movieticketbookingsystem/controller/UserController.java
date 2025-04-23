package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.record.UserRegistrationRequestDTO;
import com.example.movieticketbookingsystem.record.UserRegistrationResponseDTO;
import com.example.movieticketbookingsystem.service.UserService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userservice;

    @PostMapping
    public ResponseEntity<ResponseStructure<UserRegistrationResponseDTO>> register(@RequestBody UserRegistrationRequestDTO userregistrationrequestDTO){

        UserRegistrationResponseDTO user= userservice.register(userregistrationrequestDTO);

        ResponseStructure<UserRegistrationResponseDTO> rs=new ResponseStructure<UserRegistrationResponseDTO>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("registered  successfully");
        rs.setData(user);

        return new ResponseEntity<ResponseStructure<UserRegistrationResponseDTO>>(rs,HttpStatus.CREATED);
    }


}
