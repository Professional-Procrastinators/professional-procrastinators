package org.launchcode.professionalprocrastinators.controllers;
import org.launchcode.professionalprocrastinators.models.Activity;
import org.launchcode.professionalprocrastinators.models.data.ActivityRepository;
import org.launchcode.professionalprocrastinators.models.data.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.launchcode.professionalprocrastinators.models.Vacation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;


@Controller
public class HomeController {

    @Autowired
    private VacationRepository vacationRepository;

    @Autowired
    private ActivityRepository activityRepository;


    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("title", "My Vacations");
        model.addAttribute("vacations", vacationRepository.findAll());
        model.addAttribute("activities", activityRepository.findAll());

        return "index";
    }

    @PostMapping(value= "/")
        public String processVacationCountdown(@RequestParam LocalDateTime countdownDate, Model model){

        model.addAttribute("vacations", vacationRepository.findAll());
        model.addAttribute("activities", activityRepository.findAll());

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
                                         @RequestParam(required = false) LocalDateTime vacationDate,
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
    public String processEditVacationForm(@RequestParam int selectedVacation,
                                          @RequestParam String vacationName,
                                          @RequestParam String vacationCountry,
                                          @RequestParam (required =false) String vacationState,
                                          @RequestParam LocalDateTime vacationDate,
                                          @RequestParam String visibility) {

        Vacation editedVacation = vacationRepository.findById(selectedVacation).orElse(new Vacation());


            editedVacation.setCity(vacationName);
            editedVacation.setCountry(vacationCountry);
            editedVacation.setState(vacationState);
            editedVacation.setVacationDate(vacationDate);
            editedVacation.setVisibility(visibility);
            vacationRepository.save(editedVacation);

        return "redirect:/";
    }

    @GetMapping("add-activity")
    public String displayAddActivityForm(Model model) {
        model.addAttribute("title", "Add Trip Inspiration");
        model.addAttribute("vacations", vacationRepository.findAll());
        return "/add-activity";
    }

    @PostMapping("add-activity")
    public String processAddActivityForm(@RequestParam String title,
                                         @RequestParam String url,
                                         @RequestParam int vacationId,
                                         @RequestParam(required = false) String notes) {

        Vacation linkedVacation = vacationRepository.findById(vacationId).orElse(new Vacation());

        Activity addedActivity = new Activity(title, url, linkedVacation, notes);

        String embedUrl= addedActivity.embedUrl(url);

        addedActivity.setEmbedUrl(embedUrl);

        activityRepository.save(addedActivity);

        linkedVacation.getActivities().add(addedActivity);

        return "redirect:/";
    }

    @GetMapping("delete-activity")
    public String displayDeleteActivityForm(Model model) {
        model.addAttribute("title", "Delete Activity");
        model.addAttribute("activities", activityRepository.findAll());
        return "/delete-activity";
    }

    @PostMapping("delete-activity")
    public String processDeleteActivityForm(@RequestParam(required = false) int deletedActivity) {
        activityRepository.deleteById(deletedActivity);
        return "redirect:/";
    }

}

