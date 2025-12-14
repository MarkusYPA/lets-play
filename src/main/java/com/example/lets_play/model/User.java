package com.example.lets_play.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 50)
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Size(max = 50)
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, max = 120, message = "Password must be at least 6 characters")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private String password;

    private String role; // e.g., "ROLE_USER", "ROLE_ADMIN"
}