package com.csci4050.movie.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "casts")
public class Cast {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int caid;

    @Column(name= "name")
    private String name;
}
