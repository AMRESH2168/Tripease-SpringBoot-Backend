package com.example.tripease.transformer;

import com.example.tripease.dto.request.CabRequest;
import com.example.tripease.dto.response.CabResponse;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Driver;

public class CabTransformer {

    public static Cab cabRequestToCabEntity(CabRequest cabRequest){

      return   Cab.builder()
                .cabModel(cabRequest.getCabModel())
                .cabNumber(cabRequest.getCabNumber())
                .perKmRate(cabRequest.getPerKmRate())
                .available(true)
                .build();

    }


    public static CabResponse cabEntityToCabResponse(Cab cab, Driver driver){
        return  CabResponse.builder()
                .cabNumber(cab.getCabNumber())
                .cabModel(cab.getCabModel())
                .perKmRate(cab.getPerKmRate())
                .available(cab.isAvailable())
                .driverResponse(DriverTransformer.driverEntityToDriverResponce(driver))
                .build();


    }
}
