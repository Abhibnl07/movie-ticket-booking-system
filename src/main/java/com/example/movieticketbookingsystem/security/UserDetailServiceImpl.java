package com.example.movieticketbookingsystem.security;

import com.example.movieticketbookingsystem.entity.UserDetails;  // Your entity
import com.example.movieticketbookingsystem.repository.UserDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Fetch the user directly (not Optional)
        UserDetails appUser = userDetailsRepository.findByEmail(username);

        if (appUser == null) {
            // If user not found, throw UsernameNotFoundException
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // Return a Spring Security User with the user's email and password
        return User.builder()
                .username(appUser.getEmail()) // Set username as email
                .password(appUser.getPassword()) // Set password from the entity
                .authorities(appUser.getRole().name()) // Assuming your UserDetails has a role
                .build();
    }
}
