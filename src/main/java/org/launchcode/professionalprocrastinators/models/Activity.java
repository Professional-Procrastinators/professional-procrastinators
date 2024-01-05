package org.launchcode.professionalprocrastinators.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Activity {

    @Id
    @GeneratedValue
    private int id;

    private String url;

    @ManyToOne
    private Vacation vacation;

    private String notes;

    public Vacation getLinkedVacation() {
        return vacation;
    }

    public void setLinkedVacation(Vacation vacation) {
        this.vacation = vacation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "url='" + url + '\'' +
                ", vacation=" + vacation +
                ", notes='" + notes + '\'' +
                '}';
    }

    public Activity(String url, Vacation vacation, String notes) {
        this.url = url;
        this.vacation = vacation;
        this.notes = notes;
    }

    public Activity() {}
}
