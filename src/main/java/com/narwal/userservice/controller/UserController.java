package com.narwal.userservice.controller;

import com.narwal.userservice.model.User;
import com.narwal.userservice.model.UserRequestBody;
import com.narwal.userservice.service.RoleService;
import com.narwal.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update/{email}")
    public void updateUser(@PathVariable String email, @RequestBody User user) {
        System.out.println(user);
        userService.updateUser(email, user);
    }

    @DeleteMapping("/delete/{email}")
    public void deleteUser(@PathVariable("email") String email) {
        userService.deleteUser(email);
    }

}
