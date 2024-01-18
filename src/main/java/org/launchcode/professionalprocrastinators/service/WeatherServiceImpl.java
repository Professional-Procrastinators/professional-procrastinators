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


    private final String apikey;
    private final RestTemplate restTemplate;
    private String locationKey;

    @Autowired
    public WeatherServiceImpl(@Value("${weather.api.key}") String apiKey, RestTemplate restTemplate) {
        this.apikey = apiKey;
        this.restTemplate = restTemplate;
    }
    private String buildWeatherUrl(LocationInformation locationInformation){
        String accuWeatherForecastUrl = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/";
        String endApi = "?apikey=" + apikey;
        System.out.println(locationInformation);
        locationKey = (String) locationInformation.getKey();
//        locationKey = locationInformation[0].Key;
        System.out.println(locationKey);
        return accuWeatherForecastUrl + locationKey + endApi;
    }

    public WeatherInformation getWeatherInfo(LocationInformation locationInformation) {
        try {

                String apiUrl = buildWeatherUrl(locationInformation);
            System.out.println(apiUrl);
                ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
                if (responseEntity.getStatusCode() == HttpStatus.OK) {
                    String weatherJsonString = responseEntity.getBody();
                    return WeatherParser.parseWeatherJson(weatherJsonString);
                } else {
                    System.out.println("Error calling the weather API. Status code: " + responseEntity.getStatusCode());
                }

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
        return null;
    }
}
