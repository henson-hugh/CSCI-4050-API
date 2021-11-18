package com.csci4050.movie.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int aid;

    @Column(name= "userid")
    private int userid;
}
