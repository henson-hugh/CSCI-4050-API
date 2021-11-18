package com.csci4050.movie.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "showings")
public class Showing {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int sid;

    @Column(name = "movieid")
    private int movieid;

    @Column(name = "roomid")
    private int roomid;

    @Column(name = "time")
    private int time;

    @Column(name = "date")
    private String date;

    @Column(name = "duration")
    private int duration;

}
