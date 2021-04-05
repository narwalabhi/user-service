package com.narwal.userservice.service;

import com.narwal.userservice.model.User;
import com.narwal.userservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void createUser(User user){
        userRepo.save(user);
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }

    public void deleteUser(String email){
        userRepo.deleteByEmail(email);
    }

    public User searchUser(String email){
        return userRepo.findByEmail(email);
    }

}
