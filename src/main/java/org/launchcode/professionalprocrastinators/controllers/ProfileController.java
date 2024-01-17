package org.launchcode.professionalprocrastinators.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.launchcode.professionalprocrastinators.models.User;
import org.launchcode.professionalprocrastinators.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//import org.launchcode.professionalprocrastinators.models.data.dto.LoginFormDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserAuthentication userAuthentication;

    @GetMapping
    public String viewProfile(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        User user = userAuthentication.getUserFromSession(session);

        if (user == null) {
            return "login";
        }
        model.addAttribute("username", user.getUsername());
        model.addAttribute("name", user.getName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("passwordHash", user.getPasswordHash());
//       Need to connect to UserAuthentication, but can't until it's connected to UserRepository
        return "profile";
    }
}
// TODO: Update to fetch USer name, check out my previous code form before the merge
