package org.launchcode.professionalprocrastinators.models;


import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Vacation {

    private int id;
    private static int nextId = 1;

    @NotNull
    private String city;

    @NotNull
    private String country;

    private String state;

    private Date vacationDate;

    @Override
    public String toString() {
        return "Vacation{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", vacationDate=" + vacationDate +
                '}';
    }

    public Date getVacationDate() {
        return vacationDate;
    }

    public void setVacationDate(Date vacationDate) {
        this.vacationDate = vacationDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public Vacation(String city, String country, String state) {
        this.city = city;
        this.country=country;
        this.state= state;
        this.id = nextId;
        nextId++;
    }

}
