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

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("title", "My Vacations");
        model.addAttribute("vacations", vacationRepository.findAll());
        return "index";
    }

    @GetMapping(value = "add-vacation")
    public String displayAddVacationForm(Model model) {
        model.addAttribute("title", "Add Vacation");
        return "add-vacation";
    }

    @PostMapping("add-vacation")
    public String processAddVacationForm(@RequestParam String vacationName,
                                         @RequestParam String vacationCountry,
                                         @RequestParam(required = false) String vacationState,
                                         @RequestParam (required=false) LocalDateTime vacationDate,
                                         @RequestParam String visibility) {

        vacationRepository.save(new Vacation(vacationName, vacationCountry, vacationState, vacationDate, visibility));
        return "redirect:";
    }

    @GetMapping("delete-vacation")
    public String displayDeleteVacationForm(Model model) {
        model.addAttribute("title", "Delete Vacation");
        model.addAttribute("vacations", vacationRepository.findAll());
        return "/delete-vacation";
    }

    @PostMapping("delete-vacation")
    public String processDeleteVacationForm(@RequestParam(required = false) int deletedVacation) {
        vacationRepository.deleteById(deletedVacation);
        return "redirect:/";
        }

    @GetMapping("edit-vacation")
    public String displayEditVacationForm(Model model) {
        model.addAttribute("title", "Edit Vacation");
        model.addAttribute("vacations", vacationRepository.findAll());
        return "/edit-vacation";
    }

    @PostMapping("edit-vacation")
    public String processVacationSelectionToEdit(Model model, @RequestParam int selectedVacation) {

        model.addAttribute("editedVacation", vacationRepository.findById(selectedVacation));
        return ("/edit-input");

        }

        @GetMapping("edit-input")
        public String displayNextPageEditVacation(Model model) {
            model.addAttribute("title", "Edit Vacation");
            model.addAttribute("editedVacation", editedVacation);
            return "redirect:/";
        }

        @PostMapping("edit-input")
        public String processEditVacationForm(@RequestParam (required = false) String vacationName,
                                              @RequestParam (required = false) String vacationCountry,
                                              @RequestParam (required = false) String vacationState,
                                              @RequestParam (required = false) LocalDateTime vacationDate,
                                              @RequestParam String visibility) {
            if (vacationName != null){
                selectedVacation.setCity(vacationName);
            }

            if (vacationCountry != null){
                selectedVacation.setCountry(vacationCountry);
            }

            if (vacationState != null){
                selectedVacation.setState(vacationState);
            }

            if (vacationDate != null) {
                selectedVacation.setVacationDate(vacationDate);
            }

            selectedVacation.setVisibility(visibility);

            return "redirect:/";
        }
}

