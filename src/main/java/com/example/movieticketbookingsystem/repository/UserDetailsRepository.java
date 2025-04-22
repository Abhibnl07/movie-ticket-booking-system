package com.example.movieticketbookingsystem.repository;

import com.example.movieticketbookingsystem.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDetailsRepository extends JpaRepository<UserDetails,String> {


    public boolean existsByEmail(String email);
}
