package org.launchcode.professionalprocrastinators.controllers;

import org.launchcode.professionalprocrastinators.models.Activity;
import org.launchcode.professionalprocrastinators.models.Likes;
import org.launchcode.professionalprocrastinators.models.User;
import org.launchcode.professionalprocrastinators.models.Vacation;
import org.launchcode.professionalprocrastinators.models.data.LikesRepository;
import org.launchcode.professionalprocrastinators.models.data.UserRepository;
import org.launchcode.professionalprocrastinators.models.data.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.OptionalInt;

@Controller
public class LikeButtonController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private VacationRepository vacationRepository;

    @GetMapping("/likes")
    public String displayLikesForm(Model model) {
        model.addAttribute("vacations", vacationRepository.findByVisibility("Public"));
        model.addAttribute("likes", new Likes());
        return "likes";
    }

    @PostMapping("/likes")
    public String processLikesForm(@ModelAttribute Likes likes, @RequestParam("userId") int userId, @RequestParam("vacationID") int vacationId, Model model)
    { User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        Vacation vacation = vacationRepository.findById(vacationId).orElseThrow(() -> new IllegalArgumentException("Invalid vacation ID"));
        likes.setUser(user);
        likes.setVacation(vacation);
        likes.setLikes(likes.getLikes()+ 1);
        likesRepository.save(likes);
        model.addAttribute("successMessage", "Liked Successful!");
        return "redirect:/";
    }

}
