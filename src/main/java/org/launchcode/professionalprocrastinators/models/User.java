package org.launchcode.professionalprocrastinators.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "user")
    private List<Likes> likes;

    @NotNull
       private String username;
        private String password;
       private String name;
        private String email;
        private String location;
        private String numOfVacations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getNumOfVacations() {
        return numOfVacations;
    }

    public void setNumOfVacations(String numOfVacations) {
        this.numOfVacations = numOfVacations;
    }
    @Override
    public String toString() {
        return "Username: '" + username + "', Name: '" + name + "', Location: '" + location + "', Vacations Taken: " + numOfVacations;
    }
}

//TODO: Set up user information variables, with getters and setters
//TODO: How to connect SQL URL with React URL @CrossOrigin?

