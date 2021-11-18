package com.csci4050.movie.api.promotion;

import lombok.Data;

@Data
public class PromotionDto {

    private int pid;

    private double amount;

    private String pcode;
}
