package org.launchcode.professionalprocrastinators.controllers;

import ch.qos.logback.core.model.Model;
import org.launchcode.professionalprocrastinators.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class UserController {

    @GetMapping(value = "/login")
    public String loginProcessForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(Model model) {
        return ":redirect";
    }

    @GetMapping(value = "/create_account")
    public String createAccountProcessFrom(Model model) {
        return "create-account";
    }


    @Autowired
    private UserRepository userRepository;
    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
}
