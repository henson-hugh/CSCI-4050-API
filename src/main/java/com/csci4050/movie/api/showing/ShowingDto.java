package com.csci4050.movie.api.showing;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ShowingDto {
    private int sid;

    private int movieid;

    private int roomid;

    private int time;

    private String date;

    private int duration;
}
