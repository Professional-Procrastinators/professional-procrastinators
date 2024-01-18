package org.launchcode.professionalprocrastinators.controllers;

import jakarta.servlet.http.*;
import org.launchcode.professionalprocrastinators.models.*;
import org.launchcode.professionalprocrastinators.models.data.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rewards")
public class RewardsController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RewardsRepository rewardsRepository;

    @Autowired
    private UserAuthentication userAuthentication; // Inject UserAuthentication

    @GetMapping
    public String showRewardsPage(HttpSession session, Model model) {
        User user = userAuthentication.getUserFromSession(session);

        if (user == null) {
            // Redirect to login if the user is not in the session
            return "redirect:/login";
        }

        Rewards rewards = rewardsRepository.findById(user.getId()).orElse(new Rewards());

        // Add 'user' and 'rewards' to the model
        model.addAttribute("user", user);
        model.addAttribute("rewards", rewards);

        return "rewards";
    }

    // Additional methods for updating rewards as proof of concept
    @PostMapping("/awardPoints")
    public String awardPoints(HttpSession session) {
        User user = userAuthentication.getUserFromSession(session);

        if (user == null) {
            // Redirect to login if the user is not in the session
            return "redirect:/login";
        }

        Rewards rewards = rewardsRepository.findById(user.getId()).orElse(new Rewards());

        // Award 4 points (modify this logic based on your requirements)
        rewards.setPoints(rewards.getPoints() + 4);
        rewardsRepository.save(rewards);

        // Redirect back to the rewards page
        return "redirect:/rewards";
    }

}