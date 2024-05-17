package com.carrental.carrentalservice.dtos;

import com.carrental.carrentalservice.models.CarType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CarRentalResponseDto {
    private String registrationNumber;
    private CarType carType;
    private String consumerName;
    private String consumerContactNo;
    private Date rentedOn;
}
