package com.narwal.userservice.service;

import com.narwal.userservice.model.User;
import com.narwal.userservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public Optional<User> updateUser(String id, User user) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User userData = optionalUser.get();
            if (!user.getFirstName().equals("")) {
                userData.setFirstName(user.getFirstName());
            }
            if (!user.getLastName().equals("")) {
                userData.setLastName(user.getLastName());
            }
            if (!user.getEmail().equals("")) {
                userData.setEmail(user.getEmail());
            }
            if (!user.getMobileNumber().equals("")) {
                userData.setMobileNumber(user.getMobileNumber());
            }
            if(!user.getGender().equals("")){
                userData.setGender(user.getGender());
            }
            if(user.getDob() != null){
                userData.setDob(user.getDob());
            }
            return Optional.of(userRepo.save(userData));
        }
        return Optional.empty();
    }

    public Optional<User> deleteUser(String id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
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

    public List<User> getAll() {
        return userRepo.findAll();
    }
}
