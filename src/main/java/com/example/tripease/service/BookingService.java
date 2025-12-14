package com.example.tripease.service;

import com.example.tripease.dto.request.BookingRequest;
import com.example.tripease.dto.response.BookingResponse;
import com.example.tripease.exceptions.CabUnavailableException;
import com.example.tripease.exceptions.CustomerNotFoundException;
import com.example.tripease.model.Booking;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Customer;
import com.example.tripease.model.Driver;
import com.example.tripease.repository.BookingRepository;
import com.example.tripease.repository.CabRepository;
import com.example.tripease.repository.CustomerRepository;
import com.example.tripease.repository.DriverRepository;
import com.example.tripease.transformer.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CabRepository cabRepository;
    @Autowired
    DriverRepository driverRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public BookingResponse bookCab(BookingRequest bookingRequest, int customerId) {

        Optional<Customer> isPresentCustomer=customerRepository.findById(customerId);

        if(isPresentCustomer.isEmpty()){
            throw  new CustomerNotFoundException("invlaid customer Id!");

        }
        Customer customer=isPresentCustomer.get();

        Cab availableCab=cabRepository.findingAvailableCabRandomly();

        if(availableCab==null){
            throw  new CabUnavailableException("cab is not available!");
        }
        Booking booking= BookingTransformer.bookingRequestToBookingEntity(bookingRequest,availableCab.getPerKmRate());
         Booking savedBookingInDB=bookingRepository.save(booking);

   availableCab.setAvailable(false);
   customer.getBookings().add(savedBookingInDB);

        Driver availableCabDriver= driverRepository.getDriverOfAvailableCab(availableCab.getCabId());
        availableCabDriver.getBookings().add(savedBookingInDB);
      Customer savedCustomer=  customerRepository.save(customer);
      Driver savedDriver=  driverRepository.save(availableCabDriver);
sendEmail(savedCustomer);
      return BookingTransformer.bookingToBookingResponse(savedBookingInDB,savedCustomer,availableCab,savedDriver);
    }

    private void sendEmail(Customer customer){
        SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
        simpleMailMessage.setFrom("amreshspringproject@gmail.com");
        simpleMailMessage.setTo(customer.getEmailId());
        simpleMailMessage.setSubject("cab booked!");
        simpleMailMessage.setText("Congrats " + customer.getName() + ", your cab is booked!");
        javaMailSender.send(simpleMailMessage);

    }
}
