package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.entity.UserDetails;
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
    public ResponseEntity<ResponseStructure<UserDetails>> register(@RequestBody UserDetails userdetails){

        UserDetails user= userservice.register(userdetails);

        ResponseStructure<UserDetails> rs=new ResponseStructure<UserDetails>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("registered  successfully");
        rs.setData(user);

        return new ResponseEntity<ResponseStructure<UserDetails>>(rs,HttpStatus.CREATED);
    }
}
