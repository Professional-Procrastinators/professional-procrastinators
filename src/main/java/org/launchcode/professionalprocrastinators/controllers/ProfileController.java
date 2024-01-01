package org.launchcode.professionalprocrastinators.controllers;


import ch.qos.logback.core.model.Model;
import org.launchcode.professionalprocrastinators.models.User;
import org.launchcode.professionalprocrastinators.models.Vacation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private static List<User> user = new ArrayList<>();
    @GetMapping
    public String viewProfile(@ModelAttribute Model model) {

        model.addAttribute("user", user);
        return "profile";
    }
}
// TODO: Create a way to fetch user data to use in viewProfile Method
// TODO: Update Controller
// TODO: Create a handler for errors
