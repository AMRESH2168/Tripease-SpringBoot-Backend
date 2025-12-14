package com.example.tripease.transformer;

import com.example.tripease.Enums.TripStatus;
import com.example.tripease.dto.request.BookingRequest;
import com.example.tripease.dto.response.BookingResponse;
import com.example.tripease.dto.response.CabResponse;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.model.Booking;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Customer;
import com.example.tripease.model.Driver;

import java.sql.Date;

public class BookingTransformer {
    public  static Booking bookingRequestToBookingEntity(BookingRequest bookingRequest,double preKmRate){
        return Booking.builder(). pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .tripDistanceInKm(bookingRequest.getTripDistanceInKm())
                .tripStatus(TripStatus.IN_PROGRESS)
                .billAmount(bookingRequest.getTripDistanceInKm()*preKmRate)
                .build();

    }

    public static BookingResponse bookingToBookingResponse (Booking booking, Customer customer, Cab cab, Driver driver){
return  BookingResponse.builder()
        .pickup(booking.getPickup())
        .destination(booking.getDestination())
        .tripDistanceInKm(booking.getTripDistanceInKm())
        .tripStatus(booking.getTripStatus())
        .billAmount(booking.getBillAmount())
        .bookedAt(booking.getBookedAt())
        .lastUpdateAt(booking.getLastUpdateAt())
        .customer(CustomerTransfromer.EntityToCustomerResponse(customer))
        .cab(CabTransformer.cabEntityToCabResponse(cab,driver))
        .build();
    }


}
