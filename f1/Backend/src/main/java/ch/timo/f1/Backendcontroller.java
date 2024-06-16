package ch.timo.f1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Backendcontroller {

        // Methode, um Fahrerdaten von einer externen API abzurufen
        @GetMapping(value = "/drivers", produces = "application/json")
        public ResponseEntity<String> getDrivers() throws IOException, InterruptedException {

                String fileUrl = "http://ergast.com/api/f1/2024/drivers.json";
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(fileUrl))
                                .build();

                try {
                        Log log = new Log("f1_log.txt"); 
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                        log.logger.info("Fahrerdaten erfolgreich abgerufen.");
                        return ResponseEntity.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .body(response.body());
                } catch (IOException | InterruptedException e) {
                        Log log = new Log("f1_log.txt"); 
                        log.logger.severe("Fehler beim Abrufen der Fahrerdaten: " + e.getMessage());
                        throw e;
                }
        }

        // Methode, um Streckendaten von einer externen API abzurufen
        @GetMapping(value = "/circuits", produces = "application/json")
        public ResponseEntity<String> getCircuit() throws IOException, InterruptedException {

                String fileUrl = "http://ergast.com/api/f1/2024/circuits.json";
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(fileUrl))
                                .build();

                try {
                        Log log = new Log("f1_log.txt"); 
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                        log.logger.info("Streckendaten erfolgreich abgerufen.");
                        return ResponseEntity.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .body(response.body());
                } catch (IOException | InterruptedException e) {
                        Log log = new Log("f1_log.txt"); 
                        log.logger.severe("Fehler beim Abrufen der Streckendaten: " + e.getMessage());
                        throw e;
                }
        }

        // Methode, um Konstrukteursdaten von einer externen API abzurufen
        @GetMapping(value = "/constructors", produces = "application/json")
        public ResponseEntity<String> getConstructors() throws IOException, InterruptedException {

                String fileUrl = "http://ergast.com/api/f1/2024/constructors.json";
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(fileUrl))
                                .build();

                try {
                        Log log = new Log("f1_log.txt"); 
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                        log.logger.info("Konstrukteursdaten erfolgreich abgerufen.");
                        return ResponseEntity.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .body(response.body());
                } catch (IOException | InterruptedException e) {
                        Log log = new Log("f1_log.txt"); 
                        log.logger.severe("Fehler beim Abrufen der Konstrukteursdaten: " + e.getMessage());
                        throw e;
                }
        }

        // Methode, um Renninformationen von einer externen API abzurufen
        @GetMapping(value = "/race", produces = "application/json")
        public ResponseEntity<String> getRace() throws IOException, InterruptedException {

                String fileUrl = "http://ergast.com/api/f1/current.json";
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(fileUrl))
                                .build();

                try {
                        Log log = new Log("f1_log.txt"); 
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                        log.logger.info("Renninformationen erfolgreich abgerufen.");
                        return ResponseEntity.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .body(response.body());
                } catch (IOException | InterruptedException e) {
                        Log log = new Log("f1_log.txt"); 
                        log.logger.severe("Fehler beim Abrufen der Renninformationen: " + e.getMessage());
                        throw e;
                }
        }
}
