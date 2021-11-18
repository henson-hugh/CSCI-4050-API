package com.csci4050.movie.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "verifications")
public class Verification {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int vid;

    @Column(name = "customerid")
    private int customerid;

    @Column(name = "vcode")
    private String vcode;
}
