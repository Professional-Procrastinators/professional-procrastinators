package org.launchcode.professionalprocrastinators.controllers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.launchcode.professionalprocrastinators.models.User;
import org.launchcode.professionalprocrastinators.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
public class PackingListController {

    @Autowired
    UserAuthentication userAuthentication;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/packing_list")
    public String displayPackingListForm(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = userAuthentication.getUserFromSession(session);
        System.out.println(user);
//        HashMap<Integer, String> quantityAndItems;
        model.addAttribute("user", user);
        return "packing-list";
    }
}
