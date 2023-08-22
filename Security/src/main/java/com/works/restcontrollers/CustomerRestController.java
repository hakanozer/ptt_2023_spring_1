package com.works.restcontrollers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import com.works.services.DB;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerRestController {

    final CustomerService customerService;
    final DB db;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Customer customer) {
        return customerService.register(customer);
    }

    @PostMapping("/customerLogin")
    public void customerLogin(@RequestParam String email, @RequestParam boolean enable) {
        db.login(email, enable);
    }


}
