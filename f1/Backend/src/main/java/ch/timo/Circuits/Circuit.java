package ch.timo.Circuits;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Circuit {

    @JsonProperty("circuitId")
    private String circuitId;

    @JsonProperty("URL")
    private String url;

    @JsonProperty("circuitName")
    private String circuitName;

    @JsonProperty("location")
    private Location location;

    
    public String getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(String circuitId) {
        this.circuitId = circuitId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

