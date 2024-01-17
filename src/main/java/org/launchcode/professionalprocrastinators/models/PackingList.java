package org.launchcode.professionalprocrastinators.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

@Entity
public class PackingList {

    @Id
    @GeneratedValue
    private int id;


//    @NotEmpty
//    @NotBlank
//    HashMap<String, Integer> listItem = new HashMap<String, Integer>();

}
