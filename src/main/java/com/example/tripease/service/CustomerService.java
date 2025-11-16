package com.example.tripease.service;


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

    public Customer addCustomer(Customer customer) {
//      Customer savedCustomer= customerRepository.save(customer);
// return  savedCustomer;
       return  customerRepository.save(customer);
    }

    public Customer getCustomer(int customedId) {
        Optional<Customer> requiredCustomer= customerRepository.findById(customedId);
   if(requiredCustomer.isEmpty()){
       throw new CustomerNotFoundException("invalid customed Id");

   }
   return requiredCustomer.get();

    }
}
