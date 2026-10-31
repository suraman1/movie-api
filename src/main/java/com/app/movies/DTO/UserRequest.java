package com.app.movies.DTO;

import com.app.movies.Models.Review;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class UserRequest {

    @NotEmpty(message = "Username is required")
    private String username;

    @Email(message = "Invalid email")
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Password is required")
    @Size(min = 10, message = "Password must be atleast 8 characters long")
    private String password;

    private List<@NotNull Review> reviews;
}
