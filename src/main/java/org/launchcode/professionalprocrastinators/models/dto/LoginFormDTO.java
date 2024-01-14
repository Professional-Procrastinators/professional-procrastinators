package org.launchcode.professionalprocrastinators.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

public class LoginFormDTO {

    @NotNull
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 16, message = "Username must be 3-16 characters long")
    private String username;

    @NotNull
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
}
