package com.example.movieticketbookingsystem.repository;

import com.example.movieticketbookingsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
