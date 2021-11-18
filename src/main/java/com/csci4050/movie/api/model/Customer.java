package com.csci4050.movie.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cid;

    @Column(name= "userid")
    private int userid;

    @Column(name = "fname")
    private String firstName;

    @Column(name = "lname")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "active", columnDefinition = "boolean default false")
    private boolean active;

    @Column(name = "verified", columnDefinition = "boolean default false")
    private boolean verified;

    @Column(name = "get_promo")
    private boolean getPromo = true;

    @Column(name = "suspend", columnDefinition = "boolean default false")
    private boolean suspend;

}

