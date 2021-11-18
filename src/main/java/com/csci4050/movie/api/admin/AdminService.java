package com.csci4050.movie.api.admin;

import com.csci4050.movie.api.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Optional<Admin> getAdminByUid(int uid) {
        return adminRepository.findByUserid(uid);
    }
}
