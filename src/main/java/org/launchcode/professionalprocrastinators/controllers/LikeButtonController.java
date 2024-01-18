package org.launchcode.professionalprocrastinators.controllers;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

import java.security.Principal;
import java.util.List;
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
    @Autowired
    UserAuthentication userAuthentication;

    @GetMapping("/likes")
    public String displayLikesForm(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = userAuthentication.getUserFromSession(session);
        model.addAttribute("userId", user.getId());
        model.addAttribute("vacations", vacationRepository.findByVisibility("public"));
        model.addAttribute("likes", new Likes());
        model.addAttribute("user", user);
        return "likes";

    }



    @PostMapping("/likes")
    public String processLikesForm(@ModelAttribute Likes likes, @RequestParam("userId") int userId, @RequestParam("vacationID") int vacationId, Model model)
    { User user = userRepository.findById(userId);
        System.out.println("Received userId: " + user.getId());
        System.out.println("Received vacationId: " + vacationId);
        Vacation vacation = vacationRepository.findById(vacationId).orElseThrow(() -> new IllegalArgumentException("Invalid vacation ID"));
        likes.setUser(user);
        likes.setVacation(vacation);
        likes.setLikes(likes.getLikes()+ 1);

        likesRepository.save(likes);
        model.addAttribute("successMessage", "Liked Successful!");
        return "redirect:/view-likes";
    }

    @GetMapping("/view-likes")
    public String viewLikedVacations(@ModelAttribute("user") User user, Model model){

        List<Likes> likedVacations =likesRepository.findByUserId(user.getId());

        model.addAttribute("likedVacations", likedVacations);
        return "view-likes";
    }

}
