package org.launchcode.professionalprocrastinators.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;


       private String username;
       private String name;
        private String email;
        private String location;
        private String numOfVacations;


}

//TODO: Set up user information variables, with getters and setters
//TODO: How to connect SQL URL with React URL @CrossOrigin?
// I think I've completed the CrossOrigins one, but leaving just in case

