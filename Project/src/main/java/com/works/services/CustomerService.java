package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import com.works.utils.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;

    public ResponseEntity save(Customer customer ) {
        if ( customer.getPassword().length() > 15 ) {
            return Rest.fail("15 char problem", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            //customer.setPassword(UUID.randomUUID().toString());
            customerRepository.save(customer);
            return Rest.success(customer);
        }catch (Exception ex) {
            return Rest.fail(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity list() {
        List<Customer> customerList = customerRepository.findAll();
        return Rest.success(customerList);
    }

    public ResponseEntity delete( String  stCid ) {
        try {
            Long cid = Long.parseLong(stCid);
            customerRepository.deleteById(cid);
            return Rest.success("Delete Success");
        }catch (Exception ex) {
            return Rest.fail(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
