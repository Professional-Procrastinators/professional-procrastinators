package org.launchcode.professionalprocrastinators.controllers.api;

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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;


@RestController
public class WeatherController {
//    Handles user input between Model and View
    @Autowired
    private VacationRepository vacationRepository;




    @Autowired
    WeatherServiceImpl weatherService;





    @GetMapping("/form")
    public String weatherForm(Model model){
        List<Vacation> vacations = vacationRepository.findAll();
        model.addAttribute("vacations",vacations);
        return "weatherForm";

    }
//    @PostMapping("/getLocationKey")
//    public String getLocationKey(@RequestParam("vacationId")String vacationId, Model model){
//        String url = accuWeatherLocationUrl + "?apikey=" + apikey +"&q=" + vacationId;
//        RestTemplate restTemplate = new RestTemplate();
//        LocationKey[] locationKeys = restTemplate.getForObject(url, LocationKey[].class);
//        if (locationKeys != null && locationKeys.length > 0) {
//            LocationKey firstLocationKey = locationKeys[0];
//            model.addAttribute("locationKey", firstLocationKey.getKey());
//        } else {
//            model.addAttribute("error", "No location keys found for the entered city");
//        }
//
//        return "locationKeyResult";
//    }

    @PostMapping("/getWeather")
    public String getWeather(@RequestParam("locationKey") Vacation vacation, String locationKey, Model model){
        try{
            LocationInformation locationInformation = LocationKeyServiceImpl.getLocationInfo(locationKey);
            WeatherInformation weatherInformation = weatherService.getWeatherInfo(locationInformation);
            model.addAttribute("weatherInfo", weatherInformation);
        } catch (Exception e){
            model.addAttribute("error", "Error getting Weather Information");
        }


        return "weatherResult";
    }



}


