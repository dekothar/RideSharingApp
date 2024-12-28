package com.design.ride.sharing.app.ridesharingapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Driver extends User {

    private String licenseNo;

    @OneToMany(mappedBy = "driver")
    private List<Ride> rides;

    @OneToMany(mappedBy = "driver")
    private List<Vehicle> vechicles;
}
