package org.launchcode.professionalprocrastinators.controllers;

import org.launchcode.professionalprocrastinators.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(Contact contact) {
        // Process the contact form submission (e.g., send an email)
        // You can add your logic here

        return "redirect:/contact?success"; // Redirect to the contact form with a success message
    }
}
