package org.launchcode.professionalprocrastinators.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

public class RegistrationFormDTO extends LoginFormDTO{

    @NotNull
    @NotBlank(message= "Password is required")
    @Size(min = 8, max = 30, message = "Password must be 8-30 characters long")
    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
