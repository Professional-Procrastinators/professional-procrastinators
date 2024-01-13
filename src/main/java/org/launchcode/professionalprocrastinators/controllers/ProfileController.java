package org.launchcode.professionalprocrastinators.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.launchcode.professionalprocrastinators.models.Nomies;
import org.launchcode.professionalprocrastinators.models.Vacation;
import org.launchcode.professionalprocrastinators.models.data.NomiesRepository;
import org.launchcode.professionalprocrastinators.models.data.VacationRepository;
import org.springframework.ui.Model;
import org.launchcode.professionalprocrastinators.models.User;
import org.launchcode.professionalprocrastinators.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@RequestMapping("/profile")
//public class ProfileController {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    VacationRepository vacationRepository;
//
//    @Autowired
//    NomiesRepository nomiesRepository;

//    @GetMapping("/profile")
//    public String viewProfile(Model model, Authentication authentication) {
//        if (authentication != null && authentication.isAuthenticated()) {
//            String username = authentication.getUsername();
//            User user = userRepository.findByUsername(username);
//            if (user != null) {
//                List<Vacation> userVacations = vacationRepository.findByUser(user);
//                int numOfVacations = userVacations.size();

//                model.addAttribute("username", username);
//                model.addAttribute("numOfVacations", numOfVacations);
//                return "profile";
//            }
//        } else {
//            return "redirect:/error";
//        }
//        return "redirect:/login";
//    }
//}


//TODO: Add a followers, and update html
//TODO: Add VacationsLiked and update html, Index?
//TODO: Add Top number of likes for the vacations the user created