package com.design.ride.sharing.app.ridesharingapp.controllers;

import com.design.ride.sharing.app.ridesharingapp.dtos.ProposeRideRequestDto;
import com.design.ride.sharing.app.ridesharingapp.dtos.ProposeRideResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ride")
public class RideController {


    @PostMapping("/propose")
    public ProposeRideResponseDto proposeRide(@RequestBody ProposeRideRequestDto proposeRideRequestDto) {
        return null;
    }
}
