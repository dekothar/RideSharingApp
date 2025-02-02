package com.design.ride.sharing.app.ridesharingapp.services;

import com.design.ride.sharing.app.ridesharingapp.dtos.UserRequestDto;
import com.design.ride.sharing.app.ridesharingapp.dtos.UserResponseDto;
import com.design.ride.sharing.app.ridesharingapp.enums.UserTypeEnum;
import com.design.ride.sharing.app.ridesharingapp.models.Passenger;
import com.design.ride.sharing.app.ridesharingapp.repositories.PassengerRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl {


    private PassengerRepositoryImpl passengerRepository;

    public PassengerServiceImpl(PassengerRepositoryImpl passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public UserResponseDto registerPassenger(UserRequestDto userRequestDto) {

        Passenger passenger = setPassengerDetails(userRequestDto);
        passengerRepository.save(passenger);
        return convertPassengerIntoUserDetails(passenger);

    }

    private static Passenger setPassengerDetails(UserRequestDto userRequestDto) {
        Passenger passenger = new Passenger();
        passenger.setName(userRequestDto.getName());
        passenger.setEmail(userRequestDto.getEmail());
        passenger.setGender(userRequestDto.getGender());
        passenger.setPassword(userRequestDto.getPassword());
        passenger.setUserType(UserTypeEnum.PASSENGER);
        return passenger;
    }

    private static UserResponseDto convertPassengerIntoUserDetails(Passenger passenger) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(passenger.getName());
        userResponseDto.setEmail(passenger.getEmail());
        userResponseDto.setGender(passenger.getGender());
        return userResponseDto;

    }
}
