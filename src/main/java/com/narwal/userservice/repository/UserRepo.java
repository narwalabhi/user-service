package com.narwal.userservice.repository;

import com.narwal.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    public void deleteByEmail(String email);

    public User findByEmail(String email);



}
