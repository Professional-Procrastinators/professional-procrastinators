package org.launchcode.professionalprocrastinators.controllers.parser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.launchcode.professionalprocrastinators.models.WeatherInformation;

import java.io.IOException;

public class WeatherParser {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static WeatherInformation parseWeatherJson(String weatherJsonString) throws IOException{
     try{
         return objectMapper.readValue(weatherJsonString, WeatherInformation.class);
     } catch (IOException e) {
         String exceptionDetails = e.toString();
         System.out.println("Exception Details: " + exceptionDetails);
         return null;
     }
    }
}
