package com.design.ride.sharing.app.ridesharingapp.models;

import com.design.ride.sharing.app.ridesharingapp.enums.UserTypeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User extends BaseModel {

    private String name;
    private String email;
    private String password;
    private String phone;
    private String gender;
    @Enumerated(EnumType.ORDINAL)
    private UserTypeEnum userType;
    private double rating;
}
