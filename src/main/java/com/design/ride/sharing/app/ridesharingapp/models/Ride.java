package com.design.ride.sharing.app.ridesharingapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Ride extends BaseModel {

    private String src;
    private String dest;
    @ManyToOne
    private Driver driver;

    @ManyToMany
    private List<Passenger> passengers;
    private int availableSeats;
    private double price;
    @ManyToOne
    private Vehicle vechicle;
}
