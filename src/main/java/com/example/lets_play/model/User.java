package com.example.lets_play.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users") // Maps this class to the 'users' collection
public class User {
    @Id // Specifies the primary key
    private String id;
    private String name;
    private String email;
    private String password; // Should store the HASHED password
    private String role;     // e.g., "ADMIN", "USER"
    // Getters, Setters, Constructors (Lombok can generate these)
}