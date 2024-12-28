package com.design.ride.sharing.app.ridesharingapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProposeRideRequestDto {

    private String src;
    private String dest;
    private long driverId;
    private long vehicleId;
    private int avlSeatCount;
}
