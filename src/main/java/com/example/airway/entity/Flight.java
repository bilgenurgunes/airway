package com.example.airway.entity;


import javax.persistence.*;

@Entity
@Table(name = "FLIGHT_DETAILS")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DepartureAirport")
    private String departureAirport;

    @Column(name = "ArrivalAirport")
    private String arrivalAirport;

    @Column(name = "PlaneID")
    private String planeId;

    public Flight(Long id, String departureAirport, String arrivalAirport, String planeId) {
        this.id = id;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.planeId = planeId;
    }

    public Flight() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }
}
