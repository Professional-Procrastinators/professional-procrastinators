package org.launchcode.professionalprocrastinators.controllers;


import ch.qos.logback.core.model.Model;
import org.launchcode.professionalprocrastinators.models.User;
import org.launchcode.professionalprocrastinators.models.Vacation;
import org.launchcode.professionalprocrastinators.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping
    public String viewProfile(Model model) {
        Optional<User> optionalUser = userRepository.findById();

        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            model.addAttribute("user", user);
        } else {
            model.addAttribute("errorMessage", "User not found");
        }
//        not sure if I need to addAttribute? Also do I need to change the name due to already having user?
//       Need to connect to UserAuthentication, commented out due to warnings
        return "profile";
    }
}
// TODO: Create a way to fetch user data to use in viewProfile Method
// TODO: Update Controller
// TODO: Create a handler for errors
//TODO: Create Conditionals
