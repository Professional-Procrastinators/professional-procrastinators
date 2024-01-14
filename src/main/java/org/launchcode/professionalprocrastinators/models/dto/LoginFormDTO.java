package org.launchcode.professionalprocrastinators.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

public class LoginFormDTO {

    @NotEmpty(message = "Can not be empty")
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 16, message = "Username must be 3-16 characters long")
    private String username;

    @NotEmpty(message = "Can not be empty")
    @NotBlank(message = "First name is required")
    private String firstName;

    @NotEmpty(message = "Can not be empty")
    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotEmpty(message = "Can not be empty")
    @NotBlank(message = "Username is required")
    @Email(message = "Must be a valid email")
    private String email;

    @NotEmpty(message = "Can not be empty")
    @NotBlank(message= "Password is required")
    @Size(min = 8, max = 30, message = "Password must be 8-30 characters long")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

