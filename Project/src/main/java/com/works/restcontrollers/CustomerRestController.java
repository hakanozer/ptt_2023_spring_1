package com.works.restcontrollers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerRestController {

    final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity save( @Valid @RequestBody Customer customer ) {
        return customerService.save(customer);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return customerService.list();
    }

    @DeleteMapping("/delete/{stCid}")
    public ResponseEntity delete( @PathVariable String stCid ) {
        return customerService.delete(stCid);
    }

}
