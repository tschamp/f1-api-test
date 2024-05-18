package ch.timo.Circuits;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CircuitJsonReader {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File circuitJsonFile = new File("C:/Users/timo.schreiber/OneDrive - ICT Berufsfachschulen Kanton Thurgau/Desktop/4. Semester/M226B/f1-springboot/f1/Backend/src/main/resources/json-files/circuits.json");

        List<Circuit> circuits = objectMapper.readValue(circuitJsonFile, new TypeReference<List<Circuit>>() {});
        
        for(Circuit circuit: circuits){
            System.out.println(circuit.getLocation());
        }
    }
}
