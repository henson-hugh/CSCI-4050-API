package com.csci4050.movie.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int mid;

    @Column(name = "title")
    private String title;

    @Column(name = "director")
    private String director;

    @Column(name = "producer")
    private String producer;

    @Column(name = "synopsis")
    private String synopsis;

    @Column(name = "trailerpic")
    private String trailerpic;

    @Column(name = "trailervid")
    private String trailervid;

    @Column(name = "rating")
    private double rating;
}
