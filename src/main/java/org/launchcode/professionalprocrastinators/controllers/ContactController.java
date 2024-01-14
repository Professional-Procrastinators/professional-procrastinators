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
        // Process the contact form submission


        return "redirect:/contact?success"; // Redirect to the contact form with a success message
    }

    /* information for where email is to be sent
    private void sendEmail(Contact contact) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("your-email@example.com");
        message.setSubject("New Contact Form Submission");
        message.setText("Name: " + contact.getName() + "\nEmail: " + contact.getEmail() + "\nMessage: " + contact.getMessage());

        javaMailSender.send(message);
    }

     */
}
