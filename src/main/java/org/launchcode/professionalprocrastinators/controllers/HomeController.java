package org.launchcode.professionalprocrastinators.controllers;

import org.launchcode.professionalprocrastinators.models.data.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.launchcode.professionalprocrastinators.models.Vacation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private VacationRepository vacationRepository;
    private static List<Vacation> vacations = new ArrayList<>();

    @GetMapping(value = "/")
    @CrossOrigin(origins = "http://localhost:3000")
    public String index(Model model) {
    model.addAttribute("title", "My Vacations");
    model.addAttribute("vacations", vacations);
    return "index";
    }

    //Will add a handler for the vacation date once database is set up.
//    @PostMapping("/")
//    public String processVacationCountdown(@RequestParam Date dateInput, String selectedVacation){
//        vacations.indexOf(selectedVacation)
//    }

    @GetMapping(value= "add-vacation")
    @CrossOrigin(origins = "http://localhost:3000")
    public String displayAddVacationForm(Model model) {
        model.addAttribute("title", "Add Vacation");
        return "add-vacation";
    }

    @PostMapping("add-vacation")
    @CrossOrigin(origins = "http://localhost:3000")
    public String processAddVacationForm(@RequestParam String vacationName,
                                         @RequestParam String vacationCountry,
                                         @RequestParam(required= false) String vacationState){

        vacations.add(new Vacation(vacationName, vacationCountry, vacationState));
        return "redirect:";
    }
}
//TODO: Create Like button
//TODO: Link Weather API and write code to use it