


import org.launchcode.professionalprocrastinators.models.LocationKey;
import org.launchcode.professionalprocrastinators.models.Vacation;
import org.launchcode.professionalprocrastinators.models.data.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Autowired
private VacationRepository vacationRepository;
@RestController
public class WeatherController {
    @Value("${weather.api.key}")
    private String apikey;
    private final String accuWeatherLocationUrl = "http://dataservice.accuweather.com/locations/v1/cities/search";
    private final String accuWeatherForecastUrl = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/";

    @GetMapping("/form")
    public String weatherForm(Model model){
        List<Vacation> vacations = vacationRepository.findAll();
        model.addAttribute("vacations",vacations);
        return "weatherForm";

    }
    @PostMapping("/getLocationKey")
    public String getLocationKey(@RequestParam("vacationId")String vacationId, Model model){
        String url = accuWeatherLocationUrl + "?apikey=" + apikey +"&q=" + vacationId;
        RestTemplate restTemplate = new RestTemplate();
        LocationKey[] locationKeys = restTemplate.getForObject(url, LocationKey[].class);
        if (locationKeys != null && locationKeys.length > 0) {
            LocationKey firstLocationKey = locationKeys[0];
            model.addAttribute("locationKey", firstLocationKey.getKey());
        } else {
            model.addAttribute("error", "No location keys found for the entered city");
        }

        return "locationKeyResult";
    }

    @PostMapping("/getWeather")
    public String getWeather(@RequestParam("locationKey") String locationKey, Model model){
        String forecastUrl = accuWeatherForecastUrl + locationKey + "?apikey=" +apikey;
        RestTemplate restTemplate = new RestTemplate();
        String dailyForecast = restTemplate.getForObject(forecastUrl,String.class);
        model.addAttribute("dailyForecast", dailyForecast);
        return "weatherResult";
    }



}

public void main() {
}
