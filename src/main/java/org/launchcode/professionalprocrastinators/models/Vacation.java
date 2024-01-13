package org.launchcode.professionalprocrastinators.models;

import jakarta.persistence.*;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vacation {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "vacation")
    private List<Likes> likes;
    @OneToMany
    private List<Activity> activites = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String city;

    private String country;

    private String state;

    private LocalDateTime vacationDate;

    private String visibility;

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", vacationDate=" + vacationDate +
                '}';
    }

    public List<Activity> getActivites() {
        return activites;
    }

    public void setActivites(List<Activity> activites) {
        this.activites = activites;
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

    public Vacation(String city, String country, String state, LocalDateTime vacationDate, String visibility) {
        this.city = city;
        this.country=country;
        this.state= state;
        this.vacationDate=vacationDate;
        this.visibility=visibility;
    }

    public Vacation() {}

}
