package com.csci4050.movie.api.customer;

import com.csci4050.movie.api.CodeGenerator;
import com.csci4050.movie.api.model.Customer;
import com.csci4050.movie.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getAllCustomersWithPromo() {
        return customerRepository.findAllByGetPromo(true);
    }


    public Optional<Customer> getCustomerByLastNameAndFirstName(String lastName, String firstName) {
        if (customerRepository.findByLastNameAndFirstName(lastName, firstName) == null) {
            return Optional.empty();
        } else {
            return customerRepository.findByLastNameAndFirstName(lastName, firstName);
        }
    }

    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    };

    public Optional<Customer> saveCustomer(Customer customer) {
        customerRepository.save(customer);
        return Optional.empty();
    }

    public Customer updateCustomer(int id, Customer updatedCustomer) {
        if (customerRepository.findById(id).isPresent()) {
            Customer customer = customerRepository.findById(id).get();
            customer.setFirstName(updatedCustomer.getFirstName());
            if (!updatedCustomer.getLastName().equals("")) {
                customer.setLastName(updatedCustomer.getLastName());
            }
            if (!updatedCustomer.getStreet().equals("")) {
                customer.setStreet(updatedCustomer.getStreet());
            }
            if (!updatedCustomer.getCity().equals("")) {
                customer.setCity(updatedCustomer.getCity());
            }
            if (!updatedCustomer.getState().equals("")) {
                customer.setState(updatedCustomer.getState());
            }
            if (!updatedCustomer.getZip().equals("")) {
                customer.setZip(updatedCustomer.getZip());
            }
            if (!updatedCustomer.getPhone().equals("")) {
                customer.setPhone(updatedCustomer.getPhone());
            }
            customer.setGetPromo(updatedCustomer.isGetPromo());

            return customerRepository.save(customer);
        } else {
            return new Customer();
        }
    }

    public Customer verifyCustomer(int cid) {
        Customer customer = customerRepository.findById(cid).get();
        customer.setActive(true);
        customer.setVerified(true);
        return customerRepository.save(customer);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    public Customer suspendCustomer(int cid, boolean suspend) {
        Customer customer = customerRepository.findById(cid).get();
        customer.setSuspend(suspend);
        return customerRepository.save(customer);
    }
}
