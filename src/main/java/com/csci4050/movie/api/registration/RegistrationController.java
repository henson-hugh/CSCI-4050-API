package com.csci4050.movie.api.registration;

import com.csci4050.movie.api.customer.CustomerService;
import com.csci4050.movie.api.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RegistrationController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) throws Exception {
        String email = customer.getEmail();
            Optional<Customer> resultCustomer = customerService.getCustomerByEmail(email);
            if (resultCustomer.equals(Optional.empty())) {
                return ResponseEntity.status(HttpStatus.ACCEPTED)
                        .body(customerService.saveCustomer(customer));
            } else {
                System.out.println("****************User with: " + email + " already exists.**************");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(customer);
            }
    }

    @PostMapping(value = "/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Customer> loginCustomer(@RequestBody Customer customer) {
        String email = customer.getEmail();
        String password = customer.getPassword();
        Optional<Customer> resultCustomer = customerService.getCustomerByEmailAndPassword(email, password);
        if (resultCustomer.equals(Optional.empty())) {
            System.out.println("**************** Invalid credentials **************");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(customer);
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(resultCustomer.get());
        }
    }
}
