package com.example.movieticketbookingsystem.serviceimpl;

import com.example.movieticketbookingsystem.entity.Theater;
import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.exception.UserNotFoundByEmail;
import com.example.movieticketbookingsystem.record.TheaterRequestDTO;
import com.example.movieticketbookingsystem.record.TheaterResponseDTO;
import com.example.movieticketbookingsystem.repository.TheaterOwnerRepository;
import com.example.movieticketbookingsystem.repository.TheaterRepository;
import com.example.movieticketbookingsystem.repository.UserDetailsRepository;
import com.example.movieticketbookingsystem.service.TheaterService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class TheaterServiceImpl implements TheaterService {

    private final TheaterOwnerRepository theaterownerrepository;
    private final TheaterRepository theaterrepository;
    private final UserDetailsRepository userdetailsrepository;


    @Override
    public TheaterResponseDTO addTheater(String email,TheaterRequestDTO theaterRequestDTO) {
        UserDetails exsituser = userdetailsrepository.findByEmail(email);
        if(exsituser==null){
            throw new UserNotFoundByEmail("user details not found email");
        }else if(!(exsituser instanceof TheaterOwner owner)) {
            throw new RuntimeException("User is not a TheaterOwner");
        }else {

            List<Theater> list = new ArrayList<Theater>();

            Theater theater=new Theater();
            theater.setName(theaterRequestDTO.name());
            theater.setAddress(theaterRequestDTO.address());
            theater.setCity(theaterRequestDTO.city());
            theater.setLandmark(theaterRequestDTO.landmark());
            theater.setCreatedBy(theaterRequestDTO.createdBy());
            list.add(theater);

            theater.setTheaterOwner(owner);

            Theater theater1=new Theater();
            theater1.setName(theaterRequestDTO.name());
            theater1.setAddress(theaterRequestDTO.address());
            theater1.setCity(theaterRequestDTO.city());
            theater1.setLandmark(theaterRequestDTO.landmark());
            theater1.setCreatedBy(theaterRequestDTO.createdBy());

            list.add(theater1);

            theater1.setTheaterOwner(owner);

            theaterrepository.saveAll(list);



            return new TheaterResponseDTO(
                    theater.getName(),
                    theater.getAddress(),
                    theater.getCity(),
                    theater.getLandmark()

            );        }

    }

    @Override
    public TheaterResponseDTO findTheaterById(String theaterId) {

        Theater theater=theaterrepository.findById(theaterId)
                .orElseThrow(() -> new RuntimeException("Theater not found with id: " + theaterId));

            return new TheaterResponseDTO(
                    theater.getName(),
                    theater.getAddress(),
                    theater.getCity(),
                    theater.getLandmark()

            );        }


    }

