package com.works.restcontrollers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import com.works.utils.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/update")
    public ResponseEntity update( @Valid @RequestBody Customer customer ) {
        return customerService.update(customer);
    }

    @PostMapping("/login")
    public ResponseEntity login( @RequestBody Customer customer ) {
        return customerService.login(customer);
    }

    @GetMapping("/search")
    public Page<Customer> customerPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "") String q
    ) {
        return customerService.customerPage(page, q);
    }


}
