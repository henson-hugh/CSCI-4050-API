package com.csci4050.movie.api.movie;

import com.csci4050.movie.api.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CastRepository castRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private CastMovieRepository castMovieRepository;

    @Autowired
    private GenreMovieRepository genreMovieRepository;

    public Optional<Movie> getMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public Optional<Movie> saveMovie(Movie movie) {
        movieRepository.save(movie);
        return Optional.empty();
    }

    public Optional<Movie> removeMovie(Movie movie) {
        movieRepository.delete(movie);
        return Optional.empty();
    }

    //Genre
    public Optional<String> getGenreByGenre(String genre) {
        Optional<Genre> g = genreRepository.findByGenre(genre);
        if (g.isPresent()) {
            return Optional.of(g.get().getGenre());
        }
        return Optional.empty();
    }

    public Optional<Genre> addGenre(String genre) {
        Genre g = new Genre();
        g.setGenre(genre);
        genreRepository.save(g);
        return Optional.of(g);
    }

    public Optional<GenreMovie> addGenreMovie(int mid, String genre) {
        Genre g = genreRepository.findByGenre(genre).get();
        GenreMovie gm = new GenreMovie();
        gm.setGenreid(g.getGid());
        gm.setMovieid(mid);
        // check if association exists
        List<GenreMovie> gmes = genreMovieRepository.findByMovieid(mid);
        for (GenreMovie gme : gmes) {
            if (gme.getGenreid() == g.getGid()) {
                return Optional.empty();
            }
        }
        genreMovieRepository.save(gm);
        return Optional.of(gm);
    }

    //Cast
    public Optional<String> getCastByName(String name) {
        Optional<Cast> c = castRepository.findByName(name);
        if (c.isPresent()) {
            return Optional.of(c.get().getName());
        }
        return Optional.empty();
    }

    public Optional<Cast> addCast(String name) {
        Cast c = new Cast();
        c.setName(name);
        castRepository.save(c);
        return Optional.of(c);
    }

    public Optional<CastMovie> addCastMovie(int mid, String name) {
        Cast c = castRepository.findByName(name).get();
        CastMovie cm = new CastMovie();
        cm.setCastid(c.getCaid());
        cm.setMovieid(mid);
        // check if associations exist
        List<CastMovie> cmes = castMovieRepository.findByMovieid(mid);
        for (CastMovie cme : cmes) {
            if (cme.getCastid() == c.getCaid()) {
                return Optional.empty();
            }
        }
        castMovieRepository.save(cm);
        return Optional.of(cm);
    }
}
