package com.csci4050.movie.api.movie;

import lombok.Data;

import javax.persistence.Column;

@Data
public class MovieDto {

    private int mid;

    private String title;

    private String director;

    private String producer;

    private String synopsis;

    private String trailerpic;

    private String trailervid;

    private double rating;
}
