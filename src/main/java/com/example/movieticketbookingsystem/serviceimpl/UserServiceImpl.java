package com.example.movieticketbookingsystem.serviceimpl;

import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.User;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.enums.UserRole;
import com.example.movieticketbookingsystem.exception.UserNotRegistered;
import com.example.movieticketbookingsystem.repository.TheaterOwnerRepository;
import com.example.movieticketbookingsystem.repository.UserDetailsRepository;
import com.example.movieticketbookingsystem.repository.UserRepository;
import com.example.movieticketbookingsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDetailsRepository userdetailsrepository;
    private final UserRepository userrepository;
    private final TheaterOwnerRepository theaterownerrepository;


    @Override
    public UserDetails register(UserDetails userdetails) {

        if (userdetailsrepository.existsByEmail(userdetails.getEmail())) {
            throw new UserNotRegistered("Email already exists!");
        } else {
            if (userdetails.getRole() == UserRole.USER) {
                User user = new User();

                user.setUsername(userdetails.getUsername());
                user.setPassword(userdetails.getPassword());
                user.setEmail(userdetails.getEmail());
                user.setPhoneNumber(userdetails.getPhoneNumber());
                user.setRole(userdetails.getRole());
                user.setDateOfBirth(userdetails.getDateOfBirth());
                user.setCreatedAt(userdetails.getCreatedAt());
                user.setUpdatedAt(userdetails.getUpdatedAt());

               return userdetailsrepository.save(user);

            } else  {
                TheaterOwner theaterowner = new TheaterOwner();

                theaterowner.setUsername(userdetails.getUsername());
                theaterowner.setPassword(userdetails.getPassword());
                theaterowner.setEmail(userdetails.getEmail());
                theaterowner.setPhoneNumber(userdetails.getPhoneNumber());
                theaterowner.setRole(userdetails.getRole());
                theaterowner.setDateOfBirth(userdetails.getDateOfBirth());
                theaterowner.setCreatedAt(userdetails.getCreatedAt());
                theaterowner.setUpdatedAt(userdetails.getUpdatedAt());

               return userdetailsrepository.save(theaterowner);
            }

        }
    }
}
