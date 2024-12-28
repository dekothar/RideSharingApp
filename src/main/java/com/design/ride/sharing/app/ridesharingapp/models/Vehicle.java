package com.design.ride.sharing.app.ridesharingapp.models;

import com.design.ride.sharing.app.ridesharingapp.enums.VehicleTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vehicle extends BaseModel{

    private String vechNo;
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private VehicleTypeEnum vechicleType;

    @ManyToOne
    private Driver driver;
    private int capacity;

}
