package com.csci4050.movie.api.movie;

import com.csci4050.movie.api.model.Cast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CastRepository extends CrudRepository<Cast, Integer> {
    Optional<Cast> findByName(String name);
}
