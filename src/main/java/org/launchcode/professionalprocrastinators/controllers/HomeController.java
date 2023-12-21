package org.launchcode.professionalprocrastinators.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String index(Model model) {

    return "index";
    }

    @GetMapping(value= "add-vacation")
    public String displayAddVacationForm(Model model) {
        return "add-vacation";
    }
}
