package com.csci4050.movie.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "promotions")
public class Promotion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int pid;

    @Column(name = "amount")
    private double amount;

    @Column(name = "pcode", unique = true)
    private String pcode;
}
