package org.launchcode.professionalprocrastinators.models;

import jakarta.persistence.*;

@Entity
public class Activity {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String url;

    @ManyToOne
    private Vacation linkedVacation;

    private String notes;

    private String embedUrl;

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

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", linkedVacation=" + linkedVacation +
                ", notes='" + notes + '\'' +
                ", embedUrl='" + embedUrl + '\'' +
                '}';
    }

    public String embedUrl(String url) {
        String[] splitUrl = url.split("=", 0);
        String embedCode = splitUrl[1];

        embedUrl= "https://www.youtube.com/embed/" + embedCode;
        return embedUrl;
    }

    public Activity(String title, String url, Vacation linkedVacation, String notes) {
        this.title = title;
        this.url = url;
        this.linkedVacation = linkedVacation;
        this.notes = notes;
    }

    public Activity() {}
}
