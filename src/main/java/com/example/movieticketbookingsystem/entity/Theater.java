package com.example.movieticketbookingsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Theater {

    @ManyToOne
    //@JoinColumn(name = "owner_id")
    private TheaterOwner theaterOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String theaterId;
    private String name;
    private String address;
    private String city;
    private String landmark;
    private Long createdAt;
    private Long updatedAt;
    private String createdBy;





}
