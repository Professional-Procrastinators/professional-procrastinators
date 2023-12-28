package org.launchcode.professionalprocrastinators.controllers;

import org.launchcode.professionalprocrastinators.data.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.launchcode.professionalprocrastinators.models.Vacation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private VacationRepository vacationRepository;
    //private static List<Vacation> vacations = new ArrayList<>();

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("title", "My Vacations");
        model.addAttribute("vacations", vacationRepository.findAll());
        return "index";
    }


    @PostMapping("/")
    public String processVacationCountdown(@RequestParam LocalDateTime vacationDate,
                                           @RequestParam Integer selectedVacation) {
        Vacation vacation= vacationRepository.findById(selectedVacation).orElse(new Vacation());
        vacation.setVacationDate(vacationDate);
        return "redirect:";
    }

    @GetMapping(value = "add-vacation")
    public String displayAddVacationForm(Model model) {
        model.addAttribute("title", "Add Vacation");
        return "add-vacation";
    }

    @PostMapping("add-vacation")
    public String processAddVacationForm(@RequestParam String vacationName,
                                         @RequestParam String vacationCountry,
                                         @RequestParam(required = false) String vacationState) {

        vacationRepository.save(new Vacation(vacationName, vacationCountry, vacationState));
        return "redirect:";
    }

    @GetMapping("delete-vacation")
    public String displayDeleteVacationForm(Model model) {
        model.addAttribute("title", "Delete Vacation");
        model.addAttribute("vacations", vacationRepository.findAll());
        return "/delete-vacation";
    }

    @PostMapping("delete-vacation")
    public String processDeleteVacationForm(@RequestParam(required = false) int[] vacationIds) {

        if (vacationIds != null) {
            for (int id : vacationIds) {
                vacationRepository.deleteById(id);
            }
        }
        return "redirect:/";
    }
}

