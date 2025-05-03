package com.example.movieticketbookingsystem.serviceimpl;

import com.example.movieticketbookingsystem.entity.Screen;
import com.example.movieticketbookingsystem.entity.Seat;
import com.example.movieticketbookingsystem.entity.Theater;
import com.example.movieticketbookingsystem.record.ScreenRegistrationRequestDTO;
import com.example.movieticketbookingsystem.record.ScreenResponseDTO;
import com.example.movieticketbookingsystem.record.SeatResponseDTO;
import com.example.movieticketbookingsystem.repository.ScreenRepository;
import com.example.movieticketbookingsystem.repository.TheaterRepository;
import com.example.movieticketbookingsystem.service.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class ScreenServiceImpl implements ScreenService {

    private final ScreenRepository screenRepository;
    private final TheaterRepository theaterRepository;
//    private final SeatRepository seatRepository;

    @Override
    public ScreenResponseDTO registerScreen(  String theaterId, ScreenRegistrationRequestDTO screenRegistrationRequestDTO) {

        // Step 1: Find Theater by ID (without Optional)
        Theater theater = theaterRepository.findById(theaterId).orElse(null);
        if (theater == null) {
            throw new RuntimeException("Theater not found with ID: " + theaterId);
        }

        // Step 2: Create and populate Screen entity
        Screen newScreen = new Screen();
        newScreen.setScreenType(screenRegistrationRequestDTO.screenType());
        newScreen.setCapacity(screenRegistrationRequestDTO.capacity());
        newScreen.setNoOfRows(screenRegistrationRequestDTO.noOfRows());
        newScreen.setTheater(theater);

        // Step 3: Generate seats based on capacity and rows
        int capacity = screenRegistrationRequestDTO.capacity();
        int noOfRows = screenRegistrationRequestDTO.noOfRows();
        int seatsPerRow = capacity / noOfRows;
        int remainingSeats = capacity % noOfRows;

        List<Seat> seatList = new ArrayList<>();

        for (int row = 0; row < noOfRows; row++) {
            char rowChar = (char) ('A' + row);
            int seatsInThisRow = seatsPerRow + (row < remainingSeats ? 1 : 0); // spread remaining seats

            for (int col = 1; col <= seatsInThisRow; col++) {
                Seat seat = new Seat();
                seat.setSeatname(rowChar + String.valueOf(col));
                seat.setScreen(newScreen);
                seatList.add(seat);
            }
        }

        newScreen.setSeats(seatList); // Assign generated seats to screen

        // Step 4: Save screen and seats in one go (CascadeType.ALL on screen.seats handles it)
        Screen savedScreen = screenRepository.save(newScreen);

        // Step 5: Prepare SeatResponse list
        List<SeatResponseDTO> seatResponseList = new ArrayList<>();
        List<Seat> savedSeats = savedScreen.getSeats();

        savedSeats.sort(Comparator.comparing(Seat::getSeatname)); // sort for better UI

        for (Seat seat : savedSeats) {
            SeatResponseDTO seatResponse = new SeatResponseDTO(seat.getSeatId(), seat.getSeatname());
            seatResponseList.add(seatResponse);
        }

        // Step 6: Prepare and return ScreenResponse
        return new ScreenResponseDTO(
                savedScreen.getScreenType(),
                savedScreen.getCapacity(),
                savedScreen.getNoOfRows(),
                seatResponseList
        );
    }

    @Override
    public ScreenResponseDTO displayScreen(String screenId) {

        Screen screen = screenRepository.findById(screenId).orElse(null);

        if (screen == null) {
            throw new RuntimeException("Screen not found with this Id");
        }

        List<Seat> seatList = screen.getSeats();
        seatList.sort(Comparator.comparing(Seat::getSeatname));

        List<SeatResponseDTO> seatResponsesList = new ArrayList<>();
        for (Seat seat : seatList) {
            seatResponsesList.add(new SeatResponseDTO(seat.getSeatId(), seat.getSeatname()));
        }

        return new ScreenResponseDTO(
                screen.getScreenType(),
                screen.getCapacity(),
                screen.getNoOfRows(),
                seatResponsesList
        );
    }

}