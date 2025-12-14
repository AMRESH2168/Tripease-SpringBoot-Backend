package com.example.tripease.transformer;

import com.example.tripease.dto.request.DriverRequest;
import com.example.tripease.dto.response.DriverResponse;
import com.example.tripease.model.Driver;

public class DriverTransformer {

  public static   Driver driverRequestToDriverEntity(DriverRequest driverRequest){
//      Driver driver=new Driver();
//      driver.setName(driverRequest.getName());
//      driver.setAge(driverRequest.getAge());
//      driver.setEmailId(driverRequest.getEmailId());

      return  Driver.builder().name(driverRequest.getName()).age(driverRequest.getAge())
              .emailId(driverRequest.getEmailId())
              .build();


    }

    public static DriverResponse driverEntityToDriverResponce(Driver driver){
      return  DriverResponse.builder().name(driver.getName())
              .age(driver.getAge())
              .emailId(driver.getEmailId())
              .driverId(driver.getDriverId())
              .build();
    }

}
