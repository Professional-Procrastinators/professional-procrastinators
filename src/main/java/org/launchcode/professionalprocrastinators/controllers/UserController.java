package org.launchcode.professionalprocrastinators.controllers;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.launchcode.professionalprocrastinators.models.User;
import org.launchcode.professionalprocrastinators.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/login")
    public String loginProcessForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(Model model) {
        return "redirect:/";
    }

    @GetMapping(value = "/create_account")
    public String createAccountProcessFrom(Model model) {
        return "create-account";
    }

    @PostMapping("/create_account")
    public String processCreateAccountForm(@RequestParam String username, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String userPassword, @RequestParam String confirmUserPassword, Model model, @ModelAttribute @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("username", username);
            model.addAttribute("firstName", firstName);
            model.addAttribute("lastName", lastName);
            model.addAttribute("email", email);
            model.addAttribute("userPassword", userPassword);
            return "create-account";
        } else {
            userRepository.save(new User(username, firstName, lastName, email, userPassword));
            return "redirect:/login";

        }

    }


}
