package org.launchcode.professionalprocrastinators.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Playlist {

    @Id
    @GeneratedValue
    private int id;

    private String url;
}
