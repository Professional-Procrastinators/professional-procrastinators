package org.launchcode.professionalprocrastinators.service;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.launchcode.professionalprocrastinators.controllers.parser.LocationInfoParser;
import org.launchcode.professionalprocrastinators.models.LocationInformation;
import org.launchcode.professionalprocrastinators.models.Vacation;
import org.launchcode.professionalprocrastinators.models.data.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LocationKeyServiceImpl implements LocationKeyService{
    // Logic to make API request, parse response, and return Weather object

    private final String apiKey;
    private final RestTemplate restTemplate;
    public static String location;
    @Autowired
    static VacationRepository vacationRepository;
    public LocationKeyServiceImpl(RestTemplate restTemplate, @Value("${weather.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    private String buildLocUrl(String location) {
        String accuWeatherLocationUrl = "http://dataservice.accuweather.com/locations/v1/cities/search";
        return accuWeatherLocationUrl + "?q=" + location + "&apikey=" + apiKey;
    }


    public List<Object> getLocationInfo(String vacationName) {

        try {
            String apiUrl = buildLocUrl(vacationName);
            System.out.println(apiUrl);
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                String locationJsonString = responseEntity.getBody();
                System.out.println(locationJsonString);
                return LocationInfoParser.parseLocationJson(locationJsonString);
            } else {
                System.out.println("Error calling the location API. Status code: " + responseEntity.getStatusCode());
                return null;
            }
        } catch (RestClientException | IOException e) {
            e.printStackTrace();
            System.out.println("Hi");
            return  null;
        }
    }

    }


