package org.launchcode.professionalprocrastinators.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SpotifyLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String link;
}