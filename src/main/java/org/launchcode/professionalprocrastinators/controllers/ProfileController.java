package org.launchcode.professionalprocrastinators.controllers;

import org.springframework.ui.Model;
import org.launchcode.professionalprocrastinators.models.User;
import org.launchcode.professionalprocrastinators.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String viewProfile(@RequestParam(name = "username", required = false) String username,Model model) {
        if (username == null) {
            return "redirect:/error";
        }

        Optional<User> optionalUser;
        optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            model.addAttribute("user", user);
        } else {
            model.addAttribute("errorMessage", "User not found");
        }
//       Need to connect to UserAuthentication, but can't until it's connected to UserRepository
        return "profile";
    }
}
//TODO: Create a way to update number of vacations created and set to numOfVacations, relationships set up, now just do the math for how many vacations

