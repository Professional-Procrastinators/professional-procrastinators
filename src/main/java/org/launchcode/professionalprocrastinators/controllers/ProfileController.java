package org.launchcode.professionalprocrastinators.controllers;


import ch.qos.logback.core.model.Model;
import org.launchcode.professionalprocrastinators.models.User;
import org.launchcode.professionalprocrastinators.models.Vacation;
import org.launchcode.professionalprocrastinators.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public String viewProfile(Model model) {
        Optional<User> optionalUser = userRepository.findById();
        
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            model.addAttribute("user", user);
        } else {
            model.addAttribute("errorMessage", "User not found");
        }
        //not sure if I need to addAttribute? Also do I need to change the name due to already having user?
        return "profile";
    }
}
// TODO: Create a way to fetch user data to use in viewProfile Method
// TODO: Update Controller
// TODO: Create a handler for errors
//TODO: Create Conditionals
//TODO: Create one-to-one, one-to-many, or many-to-many relationships