package com.csci4050.movie.api.movie;

import com.csci4050.movie.api.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer> {
    Optional<Genre> findByGenre(String genre);
}
