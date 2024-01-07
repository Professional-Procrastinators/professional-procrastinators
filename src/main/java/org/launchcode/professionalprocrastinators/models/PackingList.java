package org.launchcode.professionalprocrastinators.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class PackingList {

    @Id
    @GeneratedValue
    private int id;
}
