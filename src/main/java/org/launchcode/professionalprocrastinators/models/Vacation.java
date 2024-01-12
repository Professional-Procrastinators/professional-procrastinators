package org.launchcode.professionalprocrastinators.models;

import jakarta.persistence.*;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Vacation {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "vacation")
    private List<Likes> likes;
    @OneToMany
    private List<Activity> activites = new ArrayList<>();

    private List<String> spotifyLinks;

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

    public static String spotifyLinkMaker(String playlistLink) {
        //pattern compiles data into a compressed state which it can use Matcher to assess the data quicker than un-compiled
        Pattern pattern = Pattern.compile("/playlist/(\\w+)");
        Matcher matcher = pattern.matcher(playlistLink);
        //if a match is found,
        if (matcher.find()) {
            return "https://open.spotify.com/embed/playlist/" + matcher.group(1) + "?utm_source=generator";
        } else {
            return "Playlist not Found";
        }
    }

    public List<String> getSpotifyLinks() {
        return spotifyLinks;
    }

    public void setSpotifyLinks(String spotifyLinks) {
        this.spotifyLinks.add(spotifyLinkMaker(spotifyLinks));
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
