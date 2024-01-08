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
    private Vacation linkedVacation;

    private String notes;

    private String contentSource;

    public String getContentSource() {
        return contentSource;
    }

    public void setContentSource(String contentSource) {
        this.contentSource = contentSource;
    }

    public Vacation getLinkedVacation() {
        return linkedVacation;
    }

    public void setLinkedVacation(Vacation linkedVacation) {
        this.linkedVacation = linkedVacation;
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
                ", linkedVacation=" + linkedVacation +
                ", notes='" + notes + '\'' +
                ", contentSource='" + contentSource + '\'' +
                '}';
    }

    public Activity(String url, Vacation linkedVacation, String notes, String contentSource) {
        this.url = url;
        this.linkedVacation = linkedVacation;
        this.notes = notes;
        this.contentSource = contentSource;
    }

    public Activity() {}
}
