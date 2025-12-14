package com.example.lets_play.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    // Role can be optional, defaulting to USER
    private String role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
