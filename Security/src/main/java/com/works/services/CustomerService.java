package com.works.services;

import com.works.entities.Customer;
import com.works.entities.Role;
import com.works.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService implements UserDetailsService {

    final CustomerRepository customerRepository;
    final PasswordEncoder passwordEncoder;

    public ResponseEntity register(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(customer.getEmail());
        if (optionalCustomer.isPresent()) {
            return new ResponseEntity("All ready this email", HttpStatus.BAD_REQUEST );
        }else {
            String newPass = passwordEncoder.encode(customer.getPassword() );
            customer.setPassword(newPass);
            customerRepository.save(customer);
            return new ResponseEntity(customer, HttpStatus.OK);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(username);
        if (optionalCustomer.isPresent()){
            Customer c = optionalCustomer.get();
            return new User(
                    c.getEmail(),
                    c.getPassword(),
                    c.getEnable(),
                    true,
                    true,
                    true,
                    parseRoles( c.getRoles() )
            );
        }
        throw new UsernameNotFoundException("Username not found");
    }

    private Collection<? extends GrantedAuthority> parseRoles(List<Role> roles) {
        List<GrantedAuthority> ls = new ArrayList<>();
        for( Role item : roles ) {
            ls.add( new SimpleGrantedAuthority( item.getName() ));
        }
        return ls;
    }
}
