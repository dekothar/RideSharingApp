package com.design.ride.sharing.app.ridesharingapp.services;

import com.design.ride.sharing.app.ridesharingapp.dtos.UserRequestDto;
import com.design.ride.sharing.app.ridesharingapp.dtos.UserResponseDto;
import com.design.ride.sharing.app.ridesharingapp.enums.UserTypeEnum;
import com.design.ride.sharing.app.ridesharingapp.models.Driver;
import com.design.ride.sharing.app.ridesharingapp.repositories.DriverRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl {

    private DriverRepositoryImpl driverRepository;

    public DriverServiceImpl(DriverRepositoryImpl driverRepository) {
        this.driverRepository = driverRepository;
    }

    public UserResponseDto registerDriver(UserRequestDto userRequestDto) {

        Driver driver=setDriverDetails(userRequestDto);
        driverRepository.save(driver);
        return convertDriverIntoUserDetails(driver);
    }

    private static Driver setDriverDetails(UserRequestDto userRequestDto) {
        Driver driver = new Driver();
        driver.setName(userRequestDto.getName());
        driver.setEmail(userRequestDto.getEmail());
        driver.setPhone(userRequestDto.getPhone());
        driver.setPassword(userRequestDto.getPassword());
        driver.setUserType(UserTypeEnum.DRIVER);
        driver.setGender(userRequestDto.getGender());
        driver.setLicenseNo(userRequestDto.getLicenseNo());
        return driver;
    }

    private static UserResponseDto convertDriverIntoUserDetails(Driver driver) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(driver.getName());
        userResponseDto.setEmail(driver.getEmail());
        userResponseDto.setGender(driver.getGender());
        userResponseDto.setLicenseNo(driver.getLicenseNo());
        return userResponseDto;
    }
}
