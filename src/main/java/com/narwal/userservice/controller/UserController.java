package com.narwal.userservice.controller;

import com.narwal.userservice.model.RegisterResponse;
import com.narwal.userservice.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/")
    public User registerUser(@RequestBody User user){
        return null;
    }

}
