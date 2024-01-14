package org.launchcode.professionalprocrastinators.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.*;

import java.util.List;


@Entity
public class User {


    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "user")
    private List<Likes> likes;

    @NotBlank
    @Size(min = 3, max = 16)
       private String username;

    @NotBlank
    private String name;

    @NotBlank
    @Email(message = "Email must be valid.")
    private String email;

    @NotBlank
    @Size(min = 5, max = 16, message = "Password must be between 5 and 16 characters")
    private String pwHash;

    private String location;

    private int numOfVacations;

    //No Args constructor for validation
    public User(){
    }

    public User(@NotNull String username, @NotNull String name, @NotNull String email, @NotNull String password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.pwHash = encoder.encode(password);
    }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Boolean isMatchingPassword(String password){
        return encoder.matches(password, pwHash);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return pwHash;
    }

    public void setPassword(String password) {
        this.pwHash = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumOfVacations() {
        return numOfVacations;
    }

    public void setNumOfVacations(int numOfVacations) {
        this.numOfVacations = numOfVacations;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Username: '" + username + "', Name: '" + name + "', Location: '" + location + "', Vacations Taken: " + numOfVacations;
    }
}



