package org.launchcode.professionalprocrastinators.controllers;

import org.launchcode.professionalprocrastinators.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
}
