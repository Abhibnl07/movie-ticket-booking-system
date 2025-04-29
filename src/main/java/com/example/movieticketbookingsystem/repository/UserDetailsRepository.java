package com.example.movieticketbookingsystem.repository;

import com.example.movieticketbookingsystem.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails,String> {


    public boolean existsByEmail(String email);
    UserDetails findByEmail(String email);
}
