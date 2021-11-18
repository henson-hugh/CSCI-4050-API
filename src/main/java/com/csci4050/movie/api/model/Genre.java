package com.csci4050.movie.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int gid;

    @Column(name= "genre")
    private String genre;
}
