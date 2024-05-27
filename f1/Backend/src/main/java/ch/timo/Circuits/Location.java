package ch.timo.Circuits;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("long")
    private String lng;

    @JsonProperty("locality")
    private String locality;

    @JsonProperty("country")
    private String country;


    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
