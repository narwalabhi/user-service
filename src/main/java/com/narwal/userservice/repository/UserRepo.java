package com.narwal.userservice.repository;

import com.narwal.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    public Optional<User> findByEmail(String email);

}
