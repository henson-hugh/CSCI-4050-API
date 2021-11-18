package com.csci4050.movie.api.movie;

import com.csci4050.movie.api.model.CastMovie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CastMovieRepository extends CrudRepository<CastMovie, Integer> {
    List<CastMovie> findByMovieid(int movieid);
}
