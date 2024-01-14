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
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email(message = "Email must be valid.")
    private String email;

    @NotBlank
    @Size(min = 5, max = 16, message = "Password must be between 5 and 16 characters")
    private String password;

    private String location;

    private int numOfVacations;

    //No Args constructor for validation
    public User(){
    }

    public User(@NotNull String username, @NotNull String firstName, @NotNull String lastName, @NotNull String email, @NotNull String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Override
    public String toString() {
        return "Username: '" + username + "', Name: '" + firstName + "', Location: '" + location + "', Vacations Taken: " + numOfVacations;
    }
}



