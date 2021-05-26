package com.narwal.userservice.controller;

import com.narwal.userservice.exception.ApiRequestException;
import com.narwal.userservice.exception.UserNotFoundException;
import com.narwal.userservice.model.User;
import com.narwal.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @Bean
    private BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        System.out.println(user);
        user.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
        try {
            return ResponseEntity.ok(userService.createUser(user));
        } catch (Exception e) {
            throw new ApiRequestException("Email/Mobile Already exists.");
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        System.out.println(user);
        Optional<User> userData = userService.updateUser(id, user);
        if (userData.isPresent()) {
            return ResponseEntity.ok(userData.get());
        } else throw new UserNotFoundException("User with id " + id + " was not found.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String id) {
        Optional<User> user = userService.deleteUser(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else throw new UserNotFoundException("User with id " + id + " was not found.");
    }

    @GetMapping("/get-by-email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        System.out.println("user");
        Optional<User> user = userService.findUserByEmail(email);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else throw new UserNotFoundException("User with email " + email + " was not found.");
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else throw new UserNotFoundException("User with id " + id + " was not found.");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

}
