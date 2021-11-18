package com.csci4050.movie.api.user;


import com.csci4050.movie.api.model.Customer;
import com.csci4050.movie.api.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findById(int id);
    Optional<User> findByEmail(String email);
}
