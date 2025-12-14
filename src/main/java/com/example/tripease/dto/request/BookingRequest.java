package com.example.tripease.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookingRequest {
    private String pickup;
    private String destination;

    private double tripDistanceInKm;
}
