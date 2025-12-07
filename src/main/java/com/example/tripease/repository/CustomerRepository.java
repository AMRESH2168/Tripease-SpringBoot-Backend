package com.example.tripease.repository;

import com.example.tripease.Enums.Gender;
import com.example.tripease.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Integer> {

List<Customer> findByGender(Gender gender);
}
