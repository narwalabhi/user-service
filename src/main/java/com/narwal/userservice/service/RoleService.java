package com.narwal.userservice.service;

import com.narwal.userservice.model.Role;
import com.narwal.userservice.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role createRole(Role role){
        return roleRepo.save(role);
    }

    public Role updateRole(Role role){
        return roleRepo.save(role);
    }

}
