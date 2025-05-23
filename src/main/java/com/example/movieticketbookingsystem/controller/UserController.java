package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.record.UserRegistrationRequestDTO;
import com.example.movieticketbookingsystem.record.UserRegistrationResponseDTO;
import com.example.movieticketbookingsystem.record.UserUpdateRequestDTO;
import com.example.movieticketbookingsystem.service.UserService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userservice;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserRegistrationResponseDTO>> register(@Valid @RequestBody UserRegistrationRequestDTO userregistrationrequestDTO){

        UserRegistrationResponseDTO user= userservice.register(userregistrationrequestDTO);

        ResponseStructure<UserRegistrationResponseDTO> rs=new ResponseStructure<UserRegistrationResponseDTO>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("registered  successfully");
        rs.setData(user);

        return new ResponseEntity<ResponseStructure<UserRegistrationResponseDTO>>(rs,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<String>> userDetailsUpdate(@RequestParam String email, @RequestBody UserUpdateRequestDTO userupdaterequestDTO){

        String user= userservice.userDetailsUpdate(email,userupdaterequestDTO);

        ResponseStructure<String> rs=new ResponseStructure<String>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("user details updated  successfully");
        rs.setData(user);

        return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseStructure<String>> userSoftDelete(@RequestParam String email){

         userservice.userSoftDelete(email);

        ResponseStructure<String> rs=new ResponseStructure<String>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("user details deleted  successfully");

        return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
    }
}
