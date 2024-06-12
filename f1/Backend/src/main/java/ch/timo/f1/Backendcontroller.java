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

    @GetMapping(value = "/drivers", produces = "application/json")
    public ResponseEntity<String> getDrivers() throws IOException, InterruptedException {
        // Define the URL of the JSON file
        String fileUrl = "http://ergast.com/api/f1/2024/drivers.json";

        // Create a new HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create a new HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fileUrl))
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Return the response body directly
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response.body());
    }

    @GetMapping(value = "/circuits", produces = "application/json")
    public ResponseEntity<String> getCircuit() throws IOException, InterruptedException {
        // Define the URL of the JSON file
        String fileUrl = "http://ergast.com/api/f1/2024/circuits.json";

        // Create a new HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create a new HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fileUrl))
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Return the response body directly
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response.body());
    }

    @GetMapping(value = "/constructors", produces = "application/json")
    public ResponseEntity<String> getConstructors() throws IOException, InterruptedException {
        // Define the URL of the JSON file
        String fileUrl = "http://ergast.com/api/f1/2024/constructors.json";

        // Create a new HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create a new HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fileUrl))
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Return the response body directly
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response.body());
    }

    @GetMapping(value = "/race", produces = "application/json")
    public ResponseEntity<String> getRace() throws IOException, InterruptedException {
        // Define the URL of the JSON file
        String fileUrl = "http://ergast.com/api/f1/current.json";

        // Create a new HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create a new HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fileUrl))
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Return the response body directly
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response.body());
    }
}