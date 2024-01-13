package org.launchcode.professionalprocrastinators.controllers;

import org.launchcode.professionalprocrastinators.models.Likes;
import org.launchcode.professionalprocrastinators.models.User;
import org.launchcode.professionalprocrastinators.models.Vacation;
import org.launchcode.professionalprocrastinators.models.data.LikesRepository;
import org.launchcode.professionalprocrastinators.models.data.UserRepository;
import org.launchcode.professionalprocrastinators.models.data.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.OptionalInt;

@Controller
public class LikeButtonController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private VacationRepository vacationRepository;

//    @PostMapping("/likes")
//    public



}
