package com.example.tripease.service;


import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.exceptions.CustomerNotFoundException;
import com.example.tripease.model.Customer;
import com.example.tripease.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        // requestDTO------To-------EntityConversion--------

Customer customer=new Customer();

customer.setName(customerRequest.getName());
customer.setAge(customerRequest.getAge());
customer.setEmailId(customerRequest.getEmailId());
customer.setGender(customerRequest.getGender());
      Customer savedCustomer=   customerRepository.save(customer);

   //--------------------------Entity to ResponseDto-------------

CustomerResponse customerResponse=new CustomerResponse();
customerResponse.setName(savedCustomer.getName());
customerResponse.setAge(savedCustomer.getAge());
customerResponse.setEmailId(savedCustomer.getEmailId());


return customerResponse;
    }

    public CustomerResponse getCustomer(int customerId) {
        Optional<Customer> requiredCustomer= customerRepository.findById(customerId);
   if(requiredCustomer.isEmpty()){
       throw new CustomerNotFoundException("invalid customer Id");

   }
   Customer foundCustomer=requiredCustomer.get();

        //--------------------------Entity to ResponseDto-------------

        CustomerResponse customerResponse=new CustomerResponse();
        customerResponse.setName(foundCustomer.getName());
        customerResponse.setAge(foundCustomer.getAge());
        customerResponse.setEmailId(foundCustomer.getEmailId());

   return customerResponse;

    }
}
