package com.example.tripease.dto.request;

import com.example.tripease.dto.response.DriverResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CabRequest {


    private String cabNumber;
    private String cabModel;

    private double perKmRate;
    private boolean available;


}
