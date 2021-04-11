package com.narwal.userservice.controller;

import com.narwal.userservice.exception.ApiRequestException;
import com.narwal.userservice.exception.UserNotFoundException;
import com.narwal.userservice.model.User;
import com.narwal.userservice.model.UserRequestBody;
import com.narwal.userservice.service.RoleService;
import com.narwal.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @PostMapping("/signup")
    public User registerUser(@RequestBody User user) {
        System.out.println(user);
        userService.createUser(user);
//        roleService.createRole(user.getRole());
        return user;
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
        Optional<User> user = userService.findUserByEmail(email);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }else throw new UserNotFoundException("User with email " + email + " was not found.");
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }else throw new UserNotFoundException("User with id " + id + " was not found.");
    }

}
