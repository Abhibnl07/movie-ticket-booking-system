package com.example.movieticketbookingsystem.entity;

import com.example.movieticketbookingsystem.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private LocalDate dateOfBirth;


    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    private boolean isDeleted=false;
    private Instant deletedAt;



}
