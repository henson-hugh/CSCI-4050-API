package com.csci4050.movie.api.customer;

import com.csci4050.movie.api.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Optional<Customer> findByLastNameAndFirstName(String lastName, String firstName);
    Optional<Customer> findByUserid(int userid);
    List<Customer> findAllByGetPromo(boolean getPromo);
}
