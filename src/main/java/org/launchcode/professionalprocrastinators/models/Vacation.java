package org.launchcode.professionalprocrastinators.models;


import org.jetbrains.annotations.NotNull;

public class Vacation {

    @NotNull
    private String city;

//    @NotNull
//    private String country;
//
//    private String state;
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public Vacation(String city) {
        this.city = city;
//        this.country=country;
//        this.state= state;
    }

    @Override
    public String toString() {
        return city;
    }
}
