package org.launchcode.professionalprocrastinators.controllers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.launchcode.professionalprocrastinators.models.PackingList;
import org.launchcode.professionalprocrastinators.models.User;
import org.launchcode.professionalprocrastinators.models.data.PackingListRepository;
import org.launchcode.professionalprocrastinators.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class PackingListController {

    @Autowired
    UserAuthentication userAuthentication;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PackingListRepository packingListRepository;

    @GetMapping("/packing_list")
    public String displayPackingListForm(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = userAuthentication.getUserFromSession(session);
        System.out.println(user);
        model.addAttribute("user", user);

//        user.setLocation("This worked");
//        userRepository.save(user);
        return "packing-list";
    }

    @PostMapping("/packing_list")
    public String processPackingListForm(@RequestParam PackingList packingList, Model model, HttpServletRequest request) {

        packingListRepository.save(packingList);
        return "redirect:/packing_list";
    }

}