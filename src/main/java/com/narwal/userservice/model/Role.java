package com.narwal.userservice.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("roles")
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private String email;
    private String role;
}
