package com.example.tripease.dto.response;

import com.example.tripease.Enums.TripStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BookingResponse {
    private String pickup;
    private String destination;
    private double tripDistanceInKm;
    private TripStatus tripStatus;
    private double billAmount;
    Date bookedAt;
    Date lastUpdateAt;
    CustomerResponse customer;
    CabResponse cab;
}
