package ch.timo.Drivers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FahrerJsonReader {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File driverJsonFile = new File("C:/Users/timo.schreiber/OneDrive - ICT Berufsfachschulen Kanton Thurgau/Desktop/4. Semester/M226B/f1-springboot/f1/Backend/src/main/resources/json-files/drivers.json");

        List<Driver> drivers = objectMapper.readValue(driverJsonFile, new TypeReference<List<Driver>>() {});
        
        for(Driver driver: drivers){
            System.out.println(driver.getgivenName() + " " + driver.getFamilyName());
        }
    }
}
