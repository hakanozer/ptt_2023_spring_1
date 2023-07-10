package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import com.works.utils.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;

    public ResponseEntity save(Customer customer ) {
        try {
            customerRepository.save(customer);
            return Rest.success(customer);
        }catch (Exception ex) {
            return Rest.fail(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
