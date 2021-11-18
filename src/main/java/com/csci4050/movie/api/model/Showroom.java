package com.csci4050.movie.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "showrooms")
public class Showroom {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int rid;

    @Column(name = "seatnum")
    private int seatnum;
}
