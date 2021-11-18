package com.csci4050.movie.api.customer;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CustomerDto {
    private int cid;

    private int userid;

    private String firstName;

    private String lastName;

    private String phone;

    private String street;

    private String city;

    private String state;

    private String zip;

    private boolean active;

    private boolean verified;

    private boolean getPromo;

    private boolean suspend; // need to make sure a customer is not suspended before log in and make sure it logs you out if you are suspended and does remember me
}
