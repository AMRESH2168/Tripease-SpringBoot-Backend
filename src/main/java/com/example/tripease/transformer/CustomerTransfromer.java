package com.example.tripease.transformer;

import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.model.Customer;

public class CustomerTransfromer {

    public static Customer customerRequestToEntity(CustomerRequest customerRequest){
        Customer customer=new Customer();

        customer.setName(customerRequest.getName());
        customer.setAge(customerRequest.getAge());
        customer.setEmailId(customerRequest.getEmailId());
        customer.setGender(customerRequest.getGender());
        return customer;
    }


    public static CustomerResponse EntityToCustomerResponse(Customer savedCustomer){
        CustomerResponse customerResponse=new CustomerResponse();
        customerResponse.setName(savedCustomer.getName());
        customerResponse.setAge(savedCustomer.getAge());
        customerResponse.setEmailId(savedCustomer.getEmailId());


        return customerResponse;
    }
}
