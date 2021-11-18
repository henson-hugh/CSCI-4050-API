package com.csci4050.movie.api.showroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowroomService {

    @Autowired
    private ShowroomRepository showroomRepository;
}
