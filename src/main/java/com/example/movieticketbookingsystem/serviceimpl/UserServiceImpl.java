package com.example.movieticketbookingsystem.serviceimpl;

import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.User;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.enums.UserRole;
import com.example.movieticketbookingsystem.exception.UserNotFoundByEmail;
import com.example.movieticketbookingsystem.exception.UserNotRegistered;
import com.example.movieticketbookingsystem.record.UserRegistrationRequestDTO;
import com.example.movieticketbookingsystem.record.UserRegistrationResponseDTO;
import com.example.movieticketbookingsystem.record.UserUpdateRequestDTO;
import com.example.movieticketbookingsystem.repository.UserDetailsRepository;
import com.example.movieticketbookingsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDetailsRepository userdetailsrepository;



    @Override
    public UserRegistrationResponseDTO register(UserRegistrationRequestDTO userregistrationrequestDTO) {

        if (userdetailsrepository.existsByEmail(userregistrationrequestDTO.email())) {
            throw new UserNotRegistered("Email already exists!");
        } else {
            if (userregistrationrequestDTO.role() == UserRole.USER) {
                User user = new User();

                user.setUsername(userregistrationrequestDTO.username());
                user.setPassword(userregistrationrequestDTO.password());
                user.setEmail(userregistrationrequestDTO.email());
                user.setPhoneNumber(userregistrationrequestDTO.phoneNumber());
                user.setRole(userregistrationrequestDTO.role());
                user.setDateOfBirth(userregistrationrequestDTO.dateOfBirth());
//                user.setCreatedAt(userregistrationrequestDTO.getCreatedAt());
//                user.setUpdatedAt(userregistrationrequestDTO.getUpdatedAt());

                userdetailsrepository.save(user);

                return new UserRegistrationResponseDTO(
                        user.getUserId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getRole()
                );

            } else  {
                TheaterOwner theaterowner = new TheaterOwner();

                theaterowner.setUsername(userregistrationrequestDTO.username());
                theaterowner.setPassword(userregistrationrequestDTO.password());
                theaterowner.setEmail(userregistrationrequestDTO.email());
                theaterowner.setPhoneNumber(userregistrationrequestDTO.phoneNumber());
                theaterowner.setRole(userregistrationrequestDTO.role());
                theaterowner.setDateOfBirth(userregistrationrequestDTO.dateOfBirth());
//                theaterowner.setCreatedAt(userregistrationrequestDTO.getCreatedAt());
//                theaterowner.setUpdatedAt(userregistrationrequestDTO.getUpdatedAt());

               userdetailsrepository.save(theaterowner);

                return new UserRegistrationResponseDTO(
                        theaterowner.getUserId(),
                        theaterowner.getUsername(),
                        theaterowner.getEmail(),
                        theaterowner.getRole()
                );
            }

        }
    }

    @Override
    public String userDetailsUpdate(String email, UserUpdateRequestDTO userupdaterequestDTO) {

        UserDetails exsituser = userdetailsrepository.findByEmail(email);
        if(exsituser==null){
            throw new UserNotFoundByEmail("user details not found for updation");
        }
        else {
            exsituser.setUsername(userupdaterequestDTO.username());
            exsituser.setPhoneNumber(userupdaterequestDTO.phoneNumber());
        }

        userdetailsrepository.save(exsituser);

        return "user details updated successfully";
    }

    @Override
    public void userSoftDelete(String email) {
        UserDetails exsituser = userdetailsrepository.findByEmail(email);
        if(exsituser==null){
            throw new UserNotFoundByEmail("user details not found for deletion");
        }else if (!exsituser.isDeleted()) {
            exsituser.setDeleted(true);
            exsituser.setDeletedAt(Instant.now());
            userdetailsrepository.save(exsituser);
        }


    }


}
