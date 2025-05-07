package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.entity.Show;
import com.example.movieticketbookingsystem.record.ShowRequestDTO;

public interface ShowService {

    Show createShow(String theaterId, String screenId, ShowRequestDTO showRequestDTO);
}
