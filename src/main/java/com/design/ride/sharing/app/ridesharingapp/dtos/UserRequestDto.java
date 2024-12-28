package com.design.ride.sharing.app.ridesharingapp.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {

    private String name;
    private String email;
    private String password;
    private String phone;
    private String gender;
    private String userType;
    private String licenseNo;
}
