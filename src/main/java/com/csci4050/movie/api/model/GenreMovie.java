package com.csci4050.movie.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "genremovie")
public class GenreMovie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int gmid;

    @Column(name= "genreid")
    private int genreid;

    @Column(name = "movieid")
    private int movieid;
}
