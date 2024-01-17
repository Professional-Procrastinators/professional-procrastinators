package org.launchcode.professionalprocrastinators.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
public class PackingList {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int quantity;

    private List<String> packingList;

//    @NotEmpty
//    @NotBlank
//    HashMap<String, Integer> listItem = new HashMap<String, Integer>();

}
