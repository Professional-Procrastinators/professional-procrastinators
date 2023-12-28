package org.launchcode.professionalprocrastinators.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Entity
public class Vacation {

    @Id
    @GeneratedValue
    private int id;

    private String city;

    private String country;

    private String state;

    private LocalDateTime vacationDate;

    @Override
    public String toString() {
        return "Vacation{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", vacationDate=" + vacationDate +
                '}';
    }

    public LocalDateTime getVacationDate() {
        return vacationDate;
    }

    public void setVacationDate(LocalDateTime vacationDate) {
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
    }

    public Vacation() {}

}
