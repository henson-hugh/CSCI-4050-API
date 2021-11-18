package com.csci4050.movie.api.admin;

import com.csci4050.movie.api.model.Admin;
import com.csci4050.movie.api.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

    Optional<Admin> findByUserid(int userid);
}
