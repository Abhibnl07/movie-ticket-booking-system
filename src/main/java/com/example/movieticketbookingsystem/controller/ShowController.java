package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.entity.Show;
import com.example.movieticketbookingsystem.record.ScreenRegistrationRequestDTO;
import com.example.movieticketbookingsystem.record.ScreenResponseDTO;
import com.example.movieticketbookingsystem.record.ShowRequestDTO;
import com.example.movieticketbookingsystem.service.ShowService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ShowController {

    private final ShowService showService;


    @PostMapping("/theater/{theaterId}/screen/{screenId}")
    public ResponseEntity<ResponseStructure<Show>> createShow(@PathVariable String theaterId,
                                                                           @PathVariable String screenId,
                                                                           @RequestBody ShowRequestDTO showRequestDTO){

        Show show = showService.createShow(theaterId, screenId, showRequestDTO);

        ResponseStructure<Show> rs=new ResponseStructure<Show>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("created  successfully");
        rs.setData(show);

        return new ResponseEntity<ResponseStructure<Show>>(rs,HttpStatus.CREATED);
    }
}
