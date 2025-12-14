package com.example.tripease.service;

import com.example.tripease.dto.request.CabRequest;
import com.example.tripease.dto.response.CabResponse;
import com.example.tripease.exceptions.driverNotFoundException;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Driver;
import com.example.tripease.repository.DriverRepository;
import com.example.tripease.transformer.CabTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabService {
    @Autowired
    DriverRepository driverRepository;

    public CabResponse registerCab(CabRequest cabRequest,int driverId) {

        Optional<Driver> isPresentDriver=driverRepository.findById(driverId);
        if(isPresentDriver.isEmpty()){

   throw new driverNotFoundException("invalid driver Id!");
        }

        Driver presentDriver=isPresentDriver.get();
        Cab cab= CabTransformer.cabRequestToCabEntity(cabRequest);
        presentDriver.setCab(cab);
        Driver savedDriver= driverRepository.save(presentDriver);   // save both driver and cab

        return CabTransformer.cabEntityToCabResponse(savedDriver.getCab(),savedDriver);
    }
}
