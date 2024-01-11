package org.launchcode.professionalprocrastinators.models;

import jakarta.persistence.*;
import org.launchcode.professionalprocrastinators.models.data.UserRepository;

@Entity
public class Likes {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;
}
