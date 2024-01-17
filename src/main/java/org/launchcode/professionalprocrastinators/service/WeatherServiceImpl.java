package org.launchcode.professionalprocrastinators.service;

import org.launchcode.professionalprocrastinators.controllers.parser.WeatherParser;
import org.launchcode.professionalprocrastinators.models.LocationInformation;
import org.launchcode.professionalprocrastinators.models.WeatherInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${weather.api.key}")
    private String apikey;

    @Autowired
    private RestTemplate restTemplate;


    private String buildWeatherUrl(LocationInformation locationInformation){
        String accuWeatherForecastUrl = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/";
        String endApi = "?apikey=" + apikey;
        String locationKey = locationInformation.getKey();
        return accuWeatherForecastUrl + locationKey + endApi;
    }

    public WeatherInformation getWeatherInfo(LocationInformation locationInformation) {
        try {

                String apiUrl = buildWeatherUrl(locationInformation);
                ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
                if (responseEntity.getStatusCode() == HttpStatus.OK) {
                    String weatherJsonString = responseEntity.getBody();
                    return WeatherParser.parseWeatherJson(weatherJsonString);
                } else {
                    System.out.println("Error calling the weather API. Status code: " + responseEntity.getStatusCode());
                }

        } catch (IOException e) {
            // Log or handle the exception more gracefully
            throw new RuntimeException(e);
        }
        return null;
    }
}
