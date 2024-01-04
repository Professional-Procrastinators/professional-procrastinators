package org.launchcode.professionalprocrastinators.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    public user(){}

}

//TODO: Set up user information variables, with getters and setters
//TODO: How to connect SQL URL with React URL @CrossOrigin?

