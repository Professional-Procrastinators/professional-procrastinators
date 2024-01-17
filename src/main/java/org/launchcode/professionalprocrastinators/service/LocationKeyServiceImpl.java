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

@Service
public class LocationKeyServiceImpl implements LocationKeyService{
    // Logic to make API request, parse response, and return Weather object
    @Value("${weather.api.key}")
    private static String apikey;
    private static RestTemplate restTemplate;


    public LocationKeyServiceImpl(RestTemplate restTemplate, LocationInfoParser locationInfoParser) {
        LocationKeyServiceImpl.restTemplate = restTemplate;
    }

    private static String buildLocUrl(String location){
        String accuWeatherLocationUrl = "http://dataservice.accuweather.com/locations/v1/cities/search";
        return accuWeatherLocationUrl + "?q=" + location + "apikey=" + apikey;
    }
    public static LocationInformation getLocationInfo(String location){
        try{
            String apiUrl = buildLocUrl(location);
            ResponseEntity<String>responseEntity = restTemplate.getForEntity(apiUrl, String.class);
            if(responseEntity.getStatusCode() == HttpStatus.OK){
                String locationJsonString = responseEntity.getBody();
                return LocationInfoParser.parseLocationJson(locationJsonString);

            } else{
                System.out.println("Error calling the location API. Status code: " + responseEntity.getStatusCode());
                return null;

            }
        } catch (RestClientException | IOException e){
            e.printStackTrace();
            return null;
        }
    }


}
