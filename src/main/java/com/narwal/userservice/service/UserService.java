package com.narwal.userservice.service;

import com.narwal.userservice.model.User;
import com.narwal.userservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public void updateUser(String email, User user) {
        User userData = userRepo.findByEmail(email);
        if (userData != null) {
            userRepo.save(user);
        }
        userRepo.save(user);
    }

    public void deleteUser(String email) {
        userRepo.deleteByEmail(email);
    }

    public User searchUser(String email) {
        return userRepo.findByEmail(email);
    }

}
