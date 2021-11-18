package com.csci4050.movie.api.verification;

import com.csci4050.movie.api.model.Verification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationRepository extends CrudRepository<Verification, Integer> {
    Optional<Verification> findByVcode(String vcode);
}
