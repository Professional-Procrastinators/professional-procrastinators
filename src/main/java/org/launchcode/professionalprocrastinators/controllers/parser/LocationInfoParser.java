package org.launchcode.professionalprocrastinators.controllers.parser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.launchcode.professionalprocrastinators.models.LocationInformation;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class LocationInfoParser {

        private static final ObjectMapper objectMapper = new ObjectMapper();
        public static LocationInformation parseLocationJson(String locationJsonString) throws IOException {
            try {
                return objectMapper.readValue(locationJsonString, LocationInformation.class);
            } catch (IOException e) {
                String exceptionDetails = e.toString();
                System.out.println("Exception Details: " + exceptionDetails);
                return null;
            }
        }

}
