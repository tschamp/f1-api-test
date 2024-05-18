package ch.timo.Drivers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Driver {

        @JsonProperty("driverId")
        private String driverId;

        @JsonProperty("permanentNumber")
        private int permanentNumber;

        @JsonProperty("code")
        private String code;

        @JsonProperty("URL")
        private String URL;

        @JsonProperty("givenName")
        private String givenName;

        @JsonProperty("familyName")
        private String familyName;

        @JsonProperty("dateOfBirth")
        private String dateOfBirth;

        @JsonProperty("nationality")
        private String nationality;
    
        // Default constructor
        public Driver() {
        }
    
        // Parameterized constructor
        public Driver(String driverId, String URL, String givenName, String familyName, String dateOfBirth, String nationality){
            this.driverId = driverId;
            this.URL = URL;
            this.givenName = givenName;
            this.familyName = familyName;
            this.dateOfBirth = dateOfBirth;
            this.nationality = nationality;
        }
    public String getdriverId() {
        return this.driverId;
    }

    public void setdriverId(String driverId) {
        this.driverId = driverId;
    }

    public int getPermanentNumber() {
        return this.permanentNumber;
    }

    public void setPermanentNumber(int permanentNumber) {
        this.permanentNumber = permanentNumber;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getURL() {
        return this.URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getgivenName() {
        return this.givenName;
    }

    public void setgivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getdateOfBirth() {
        return this.dateOfBirth;
    }

    public void setdateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getnationality() {
        return this.nationality;
    }

    public void setnationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Drivers{" +
                "driverId='" + driverId + '\'' +
                ", Permanent Number=" + permanentNumber +
                ", URL='" + URL + '\'' +
                ", Given Name=" + givenName +
                ", FamilyName='" + familyName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationality=" + nationality +
                '}';
    }
}
