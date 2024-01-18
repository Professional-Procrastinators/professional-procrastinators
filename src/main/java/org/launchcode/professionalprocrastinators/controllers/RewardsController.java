package org.launchcode.professionalprocrastinators.controllers;

import org.launchcode.professionalprocrastinators.models.*;
import org.launchcode.professionalprocrastinators.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RewardsController {

    private final RewardsRepository rewardsRepository;

    @Autowired
    public RewardsController(RewardsRepository rewardsRepository) {
        this.rewardsRepository = rewardsRepository;
    }

    @GetMapping("/rewards")
    public String showRewardsPage(Model model) {
        Iterable<Rewards> rewardsList = rewardsRepository.findAll();
        model.addAttribute("rewardsList", rewardsList);
        return "rewards";
    }
}
