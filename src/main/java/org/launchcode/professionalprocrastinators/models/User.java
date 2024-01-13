package org.launchcode.professionalprocrastinators.models;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "user")
    private List<Likes> likes;

    @OneToMany(mappedBy = "user")
    private List<Vacation> vacations;

    @NotNull
       private String username;
    @NotNull
        private String password;

       private String name;

        private String email;

        private String location;
        private int numOfVacations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
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

    public int getNumOfVacations() {
        return numOfVacations;
    }

    public void setNumOfVacations(int numOfVacations) {
        this.numOfVacations = numOfVacations;
    }
    @Override
    public String toString() {
        return "Username: '" + username + "', Name: '" + name + "', Location: '" + location + "', Vacations Taken: " + numOfVacations;
    }

    }




