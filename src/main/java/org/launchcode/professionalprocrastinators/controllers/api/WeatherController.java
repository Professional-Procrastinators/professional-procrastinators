package org.launchcode.professionalprocrastinators.controllers.api;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.launchcode.professionalprocrastinators.controllers.parser.LocationInfoParser;
import org.launchcode.professionalprocrastinators.controllers.parser.WeatherParser;
import org.launchcode.professionalprocrastinators.models.LocationInformation;
import org.launchcode.professionalprocrastinators.models.Vacation;
import org.launchcode.professionalprocrastinators.models.WeatherInformation;
import org.launchcode.professionalprocrastinators.models.data.VacationRepository;
import org.launchcode.professionalprocrastinators.service.LocationKeyServiceImpl;
import org.launchcode.professionalprocrastinators.service.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;


@Controller
public class WeatherController {
//    Handles user input between Model and View
    @Autowired
    private VacationRepository vacationRepository;

    @Autowired
    LocationKeyServiceImpl locationKeyService;


    @Autowired
    WeatherServiceImpl weatherService;





    @RequestMapping("/get-weather")
    public String weatherForm(Model model){
        List<Vacation> vacations = vacationRepository.findAll();
        model.addAttribute("vacations",vacations);
        return "get-weather";

    }


    @PostMapping("/get-weather")
    public String getWeather(@RequestParam("vacationName") String vacationName, Model model) {
        try {

            LocationInformation locationInformation = locationKeyService.getLocationInfo(vacationName);

            if (locationInformation != null) {
                WeatherInformation weatherInformation = weatherService.getWeatherInfo(locationInformation);
                model.addAttribute("weatherInfo", weatherInformation);
                return "redirect:/view-weather";

            } else {
                model.addAttribute("error", "Location Information not available");
            }
        } catch (Exception e) {
            model.addAttribute("error", "Error getting Weather Information");
        }

        return "redirect:/view-weather";
    }




}


