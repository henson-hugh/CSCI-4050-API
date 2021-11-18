package com.csci4050.movie.api.movie;

import com.csci4050.movie.api.model.GenreMovie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreMovieRepository extends CrudRepository<GenreMovie, Integer> {
    List<GenreMovie> findByMovieid(int movieid);

}
