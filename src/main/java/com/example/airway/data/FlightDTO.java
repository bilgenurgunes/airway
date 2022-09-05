package com.example.airway.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightDTO {

    @JsonProperty("planeId")
    private String planeId;

    @JsonProperty("departureAirport")
    private String departure;

    @JsonProperty("arrivalAirport")
    private String arrival;

    public FlightDTO(String planeId, String departure, String arrival) {
        this.planeId = planeId;
        this.departure = departure;
        this.arrival = arrival;
    }

    public FlightDTO() {
    }

    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
}
