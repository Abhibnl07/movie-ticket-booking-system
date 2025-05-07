package com.example.movieticketbookingsystem.serviceimpl;

import com.example.movieticketbookingsystem.entity.Movie;
import com.example.movieticketbookingsystem.entity.Screen;
import com.example.movieticketbookingsystem.entity.Show;
import com.example.movieticketbookingsystem.entity.Theater;
import com.example.movieticketbookingsystem.exception.ConflictException;
import com.example.movieticketbookingsystem.exception.ResourceNotFoundException;
import com.example.movieticketbookingsystem.record.ShowRequestDTO;
import com.example.movieticketbookingsystem.repository.MovieRepository;
import com.example.movieticketbookingsystem.repository.ScreenRepository;
import com.example.movieticketbookingsystem.repository.ShowRepository;
import com.example.movieticketbookingsystem.repository.TheaterRepository;
import com.example.movieticketbookingsystem.service.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;
    private final ScreenRepository screenRepository;

    @Override
    public Show createShow(String theaterId, String screenId, ShowRequestDTO showRequestDTO) {

        // Fetch movie
        Movie movie = movieRepository.findById(showRequestDTO.movieId()).orElse(null);
        if (movie == null) {
            throw new ResourceNotFoundException("Movie not found with ID: " + showRequestDTO.movieId());
        }

        // Fetch theater
        Theater theater = theaterRepository.findById(theaterId).orElse(null);
        if (theater == null) {
            throw new ResourceNotFoundException("Theater not found with ID: " + theaterId);
        }

        // Fetch screen
        Screen screen = screenRepository.findById(screenId).orElse(null);
        if (screen == null || screen.getTheater() == null || !screen.getTheater().getTheaterId().equals(theaterId)) {
            throw new ResourceNotFoundException("Screen not found in theater with ID: " + theaterId);
        }

        // Convert epoch start time to Instant
        Instant startTime = Instant.ofEpochMilli(showRequestDTO.start_Time());

        // Compute end time using movie duration
        Instant endTime = startTime.plus(movie.getRuntime());

        // Check for time slot conflict
        boolean conflict = showRepository.existsOverlappingShow(screenId, startTime, endTime);


        if (conflict) {
            throw new ConflictException("The selected screen is not available between " + startTime + " and " + endTime);
        }

        // Create show
        Show show = new Show();
        show.setMovie(movie);
        show.setScreen(screen);
        show.setStartsAt(startTime);
        show.setEndsAt(endTime);

        return showRepository.save(show);
    }
}

