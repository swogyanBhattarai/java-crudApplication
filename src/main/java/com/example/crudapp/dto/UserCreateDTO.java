package com.example.crudapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserCreateDTO {
    @NotBlank
    @Size(min = 2, max = 20, message = "Name must be 2-20 characters long")
    private String name;

    @NotNull
    @Email
    private String email;

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}
