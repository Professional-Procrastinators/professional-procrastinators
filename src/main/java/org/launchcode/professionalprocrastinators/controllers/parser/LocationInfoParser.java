package org.launchcode.professionalprocrastinators.controllers.parser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.launchcode.professionalprocrastinators.models.LocationInformation;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.io.IOException;



public class LocationInfoParser {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Object> parseLocationJson(String locationJsonString) throws IOException {
        try {
            List<Object> jsonArray = Arrays.asList(objectMapper.readValue(locationJsonString, Object[].class));
            return jsonArray;
        } catch (IOException e) {
            String exceptionDetails = e.toString();
            System.out.println("Exception Details: " + exceptionDetails);
            return null;
        }
    }
}

