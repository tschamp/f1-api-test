package ch.timo.f1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Backendcontroller {

    @GetMapping("/drivers")
    public String getDrivers() throws IOException, InterruptedException {
        // Define the URL of the JSON file
        String fileUrl = "http://ergast.com/api/f1/2023/drivers.json";

        // Create a new HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create a new HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fileUrl))
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Return the response body
        return response.body();
    }


    @GetMapping("/constructors")
    public String getConstructors() throws IOException, InterruptedException {
        // Define the URL of the JSON file
        String fileUrl = "http://ergast.com/api/f1/2023/constructors.json";

        // Create a new HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create a new HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fileUrl))
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Return the response body
        return response.body();
    }
}


