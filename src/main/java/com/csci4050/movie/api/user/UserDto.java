package com.csci4050.movie.api.user;

import lombok.Data;

@Data
public class UserDto {

    private int uid;

    private String email;

    private String password;
}
