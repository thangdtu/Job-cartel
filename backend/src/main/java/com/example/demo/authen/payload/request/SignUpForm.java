package com.example.demo.authen.payload.request;

import lombok.Data;

import javax.validation.constraints.*;


@Data
public class SignUpForm {

    @NotNull(message = "Name is not null")
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Username is required")
    @NotNull(message = "Username is not null")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = "Username can only contain letters, numbers, underscores, and hyphens")
    private String username;

    @NotNull(message = "Password is not null")
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 50, message = "Password must be between 8 and 20 characters")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,50}$",
            message = "Password must have at least 8 characters, including at least one uppercase letter, one digit, and one special character.")
    private String password;

    @NotNull(message = "Email is not null")
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

}
