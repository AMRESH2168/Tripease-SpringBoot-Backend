package com.example.tripease.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "driver_info")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int driverId;
    @Column(name = "first_name")
    private String name;
    private int age;
    private   String emailId;
    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name = "driver_id")
    List<Booking> bookings=new ArrayList<>();

    @OneToOne
            @JoinColumn(name = "cab_id")
    Cab cab;
}