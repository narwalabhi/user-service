package com.narwal.userservice.service;

import com.narwal.userservice.model.User;
import com.narwal.userservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public Optional<User> updateUser(String id, User user) {
        Optional<User> userData = userRepo.findById(id);
        if (userData.isPresent()) {
            user.setId(id);
            return Optional.of(userRepo.save(user));
        }
        return Optional.empty();
    }

    public Optional<User> deleteUser(String id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()){
            userRepo.deleteById(id);
            return user;
        }
        return Optional.empty();
    }

    public Optional<User> findUserById(String id) {
        return userRepo.findById(id);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
