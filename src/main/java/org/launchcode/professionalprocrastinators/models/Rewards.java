package org.launchcode.professionalprocrastinators.models;


import jakarta.persistence.*;

@Entity
public class Rewards {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int points;



    public Rewards() {

    }

    public Rewards(String name, int points) {
        this.name = name;
        this.points = points;
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
