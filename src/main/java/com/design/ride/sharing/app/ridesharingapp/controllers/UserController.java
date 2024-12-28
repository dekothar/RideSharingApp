package com.design.ride.sharing.app.ridesharingapp.controllers;

import com.design.ride.sharing.app.ridesharingapp.dtos.UserRequestDto;
import com.design.ride.sharing.app.ridesharingapp.dtos.UserResponseDto;
import com.design.ride.sharing.app.ridesharingapp.enums.UserTypeEnum;
import com.design.ride.sharing.app.ridesharingapp.exceptions.DriverLicenseNoMissingException;
import com.design.ride.sharing.app.ridesharingapp.exceptions.InvalidRequestException;
import com.design.ride.sharing.app.ridesharingapp.services.DriverServiceImpl;
import com.design.ride.sharing.app.ridesharingapp.services.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

    @Autowired
    private DriverServiceImpl driverServiceImpl;

    @Autowired
    private PassengerServiceImpl passengerServiceImpl;


    @PostMapping("")
    public UserResponseDto registerUser(@RequestBody UserRequestDto userRequestDto) throws InvalidRequestException, DriverLicenseNoMissingException {

        invalidInputException(userRequestDto);
        driverLicenseNoMissingException(userRequestDto.getUserType(), userRequestDto.getLicenseNo());

        UserResponseDto userResponseDto = new UserResponseDto();
        if (userRequestDto.getUserType().equals(UserTypeEnum.DRIVER.name())) {
            userResponseDto = driverServiceImpl.registerDriver(userRequestDto);
        } else {
            userResponseDto = passengerServiceImpl.registerPassenger(userRequestDto);
        }

        return userResponseDto;

    }

    private static void driverLicenseNoMissingException(String userType, String licenseNo) throws DriverLicenseNoMissingException {
        if (userType.equals(UserTypeEnum.DRIVER.name()) && StringUtils.isEmpty(licenseNo)) {
            throw new DriverLicenseNoMissingException("License No is not provided pls provide it to process the request furthur");
        }
    }

    private static void invalidInputException(UserRequestDto userRequestDto) throws InvalidRequestException {
        if (StringUtils.isEmpty(userRequestDto.getName()) ||
                StringUtils.isEmpty(userRequestDto.getEmail()) ||
                StringUtils.isEmpty(userRequestDto.getPassword()) ||
                StringUtils.isEmpty(userRequestDto.getPhone()) ||
                StringUtils.isEmpty(userRequestDto.getUserType()) ||
                StringUtils.isEmpty(userRequestDto.getGender())) {
            throw new InvalidRequestException("Request doesn't contain the Required attribute details pls provide the required attribute to process the request furthur");
        }
    }
}
