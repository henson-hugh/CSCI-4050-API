package com.csci4050.movie.api;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.*;

@RestController
public class LoginController {
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
